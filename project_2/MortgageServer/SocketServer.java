/*
	This class will offer all the Server Socket functionality to our program.
	Each Socket will offer given functionality that will run on our server over
	a given port.
	A client can identify us on the network via a unique IP Address and a port number.
*/

import java.net.*;
import org.checkerframework.checker.mustcall.qual.MustCall;

import java.io.*;
/*
 * We will run our server and that any client program that is running that initialises
 * a connection to the server, the server can connect to it.
 *
 */

public class SocketServer{
	int portNumber = 44444;
	@MustCall("close") ServerSocket serverSocket = null;

	//This method will run the server. We will add the logic to create a new server
	//socket associated with our port number.
	public void runServer() throws IOException{
		// SocketServer.java:30: error: [assignment] incompatible types in assignment.
        //  serverSocket = new ServerSocket(portNumber); 
		// persistant error here!
		try{
				//creates a new Server Socket running over our port number
				serverSocket = new ServerSocket(portNumber);				

			/*
				Instead of operating a 1 to 1 connection between client/server, we want to
				offer the functionality in a multi-threaded environment. Each time we
				accept a connection to the client, we want to put this into a separate thread.
			*/

			//infinite loop always looking for connections
			while(true){
				/* 
				We run our server and any client program that is running that initialises
				a connection to the server, the server can accept a connection.
				*/
					@MustCall("close") Socket clientSocket = null;
				try{
					//our connection will come through our serverSocket object and
					//the accept() method will accept it always.
					clientSocket = serverSocket.accept();
				
					//Once the connection is accepted we will create a new Thread
					//MortgageRunnable m = new MortgageRunnable(clientSocket);
					//new Thread(m).start();
					//Alternative way to above line
					
					new Thread(new MortgageRunnable(clientSocket)).start();
					clientSocket.close();

				}catch(IOException e){
					System.out.println(e.getMessage());
				}

				
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		finally{
			serverSocket.close();
		}

	}
}