import java.net.*;
import java.io.*;
/*
 * This class is designed to run a Thread. It implements Runnable to do so. It will
 * facilitate the object being passed to a Thread.
 * 
 * The MortgageRunnable class is the object that is being passed into a given thread to continue its processing. This object needs to know to
 * perform a Mortgage Calculation. So we create a variable of type Mortgage inside the MortgageRunnable class.
 */

public class MortgageRunnable implements Runnable{
	
	//We will use this object to communicate to and from the client
	protected Socket clientSocket = null;
	
	private Mortgage m;

	/*
		clientSocket is the connection we have accepted from the client and
		we have assigned it locally to a Socket object.
	*/
	public MortgageRunnable (Socket clientSocket){
		this.clientSocket = clientSocket;
	}

	/*
		We want to be able to read in information from the client and write information
		out in the following run() method. Two way communication.
	*/
	public void run(){
		//Logic to perform happens in here
		try{
			/*
				We have a BufferedReader that is using an InputStreamReader() to read in what is being
				sent from the clientSocket using its getInputStream();
			*/
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			//The following deals with data going out
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

			if(in.readLine().equals("initCalculation")){
				
				//The client types in three pieces of information as Strings
				
				String arg1, arg2, arg3;
				arg1 = in.readLine(); 
				arg2 = in.readLine();
				arg3 = in.readLine();
				
				
				//This information is parsed into double values
				
				double annual_interest_rate = Double.parseDouble(arg1);
				double principle_amount = Double.parseDouble(arg2);
				double duration_years = Double.parseDouble(arg3);
				
				//Then passed to the Mortgage constructor where it is set locally there.
				
				this.m = new Mortgage(annual_interest_rate, principle_amount, duration_years);
			}
			
			//The monthly_repayments() method is called on m which performs the calculations and prints out the result.
			
			out.println(m.monthly_repayments());
			

			/*
			Any information sent by the client will be stored in arg1 on the server side.
			String arg1;
			arg1 = in.readLine();
			System.out.println("Client says: " + arg1);
			To send data back we use the PrintWriter
			out.println("Thanks for the message!!!");
			*/

		}catch(IOException e){
			e.printStackTrace();
		}
	}
}	