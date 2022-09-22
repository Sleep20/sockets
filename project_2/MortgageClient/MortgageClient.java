import java.net.*;

import org.checkerframework.checker.mustcall.qual.MustCall;

import java.io.*;
/*
 * This class represents the Mortgage Client who wants to use the Server as a service. They supply the server with
 * data to perform the Mortgage Calculations they want.
 * This information is sent to the server, where the logic will be performed and the answer returned to the client
 */

public class MortgageClient{
	
		public static void main(String [] args) throws IOException{
			/* we want to tell the client how to connect to the server socket program
			 * In order to pin-point a server, we need to know its location and its port
			 */

			String hostname = "127.0.0.1";
			int portNumber = 44444;

			//we need to now create a socket on the server side, our client socket
			@MustCall("close") Socket clientSocket;
			//The client needs to be able to communicate with the server, i.e.
			//send/receive data

			PrintWriter out;		//trying to send information from client to server
			BufferedReader in;
			InputStreamReader ir;
			//We are going to use the following BufferedReader to read in information from the console window
			BufferedReader stdIn;

			System.out.println("Client Program");
			clientSocket = new Socket(hostname, portNumber);	
			try{
				//Create our IO Streams
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				ir = new InputStreamReader(clientSocket.getInputStream());
				in = new BufferedReader(ir);
				//This next line is key to allowing the user to enter details in
				stdIn = new BufferedReader(new InputStreamReader(System.in));
				
				//The client sends initCalculation to the server and this will activate the conditional in MortgageRunnable
				out.println("initCalculation");

				System.out.println("Enter the loan % rate: ");
				//This will send what the user types in, to the server
				out.println(stdIn.readLine());
				
				System.out.println("Enter the loan amount: ");
				out.println(stdIn.readLine());
				
				System.out.println("Enter the loan duration: ");
				out.println(stdIn.readLine());			
				
				System.out.println("Server says Mortgage repayment is: " + in.readLine());	//data from server, aka the Mortgage Amount
				
			} catch(UnknownHostException e){
				System.exit(1);
			} catch(IOException e){
				System.exit(1);
			}
			finally{
				clientSocket.close();
			}
		}
}