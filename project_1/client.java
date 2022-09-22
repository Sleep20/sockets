/*
 * .io.*; is used to import the io package. This includes input and output
 * processes. For all the streaming objects such as BufferedReader etc. 
 *
 * The .net.*; is used to import the net package. This is used to get access
 * to the sockets we need and network tools.
 */

import java.io.*;
import java.net.*;

import org.checkerframework.checker.mustcall.qual.MustCall;

public class client
{
	/*
	 * Everything we do that involves sockets is going to have to be
	 * inside try catch blocks or throw an Exception. 
	 */

	public static void main(String [] args) throws Exception{
		//We create an instance of this class called CLIENT
		client CLIENT = new client();
		//We then call its run() method
		CLIENT.run();
	}

	public void run() throws Exception 
	{
		
		/*
		* A Socket object called SOCK is created that pass "localhost" as our hostname/
		* IP Address and a port called 444. This port must match the server port.
		*/
		@MustCall("close") Socket SOCK = new Socket("localhost", 2000);
		try {
		
		/*
		 * A PrintStream object is created that passes the return value of getOutputStream()
		 * of the SOCK object to the PrintStream constructor. This is whats going out
		 * from the client to the server. Note we are sending a value to the client.
		 */
		PrintStream PS = new PrintStream(SOCK.getOutputStream());
		
		/*
		* The method println() is called on the PS object and a piece of text is sent
		* as an argument from the client to the Server. The admin of the server
		* would see this.
		*/
		PS.println("Hello to SERVER from CLIENT");
		
		
		/*
		* An instance of InputStreamReader is created called IR. The argument will be
		* the getInputStream() return value called on from the SOCK object. We are
		* listening for a return value from the server.
		 */
		InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
		
		/*
		* An instance of BufferedReader is created called BR and the instance of IR
		* is passed in as an argument.
		*/
		BufferedReader BR = new BufferedReader(IR);
		
		/*
		* We are then going call readLine() from the BR object and store the returned
		* value as a String and print it to the screen. This will be what has been
		* received from the server.
		*/
		String MESSAGE = BR.readLine();
		System.out.println(MESSAGE);
	}
	catch (Exception e) {
		System.out.print(e.getMessage());
	}
	finally{
		SOCK.close();
	}
} 
}









