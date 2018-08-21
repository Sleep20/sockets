
/*
 * NOTE: We must always launch the Server first and once it is running and listening,
 * the ServerSocket is created, port number established and ready to accept a 
 * connection. 
 * Then we can run the client.
 */


/*
 * .io.*; is used to import the io package. This includes input and output
 * processes. For all the streaming objects such as BufferedReader etc. 
 *
 * The .net.*; is used to import the net package. This is used to get access
 * to the sockets we need and network tools.
 */

import java.io.*;
import java.net.*;

/**
 * 
 */
public class server
{
	/*
	 * Everything we do that involves sockets is going to have to be
	 * inside try catch blocks or throw an Exception. 
	 */

    public static void main(String [] args) throws Exception{
    	//We create an instance of this class called SERVER
    	server SERVER = new server();
    	//We then call its run() method
    	SERVER.run();
    }

    public void run()	throws Exception{
    	//A new ServerSocket is built and it will open up on port 2000
    	//NOTE: when using MacOS, your port must be over 1024 to avoid access privilage issues.
    	ServerSocket SRVSOCK = new ServerSocket(2000);

    	/* A new Socket object is built and the accept() method on ServerSocket is called.
    	 * The return Socket object is going to be assigned to SOCK.
    	 */
    	Socket SOCK = SRVSOCK.accept();

    	/*
		 * InputStreamReader object is created called IR. and the argument is going to
		 * be the getInputStream() return value from the Socket object. Will be passed
		 * to the InputStreamReader's constructor.
    	 */
    	InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());

    	/*
		 * An instantiation of BufferedReader object is created called BR. The
		 * InputStreamReader object is then passed as an argument.
    	 */
    	BufferedReader BR = new BufferedReader(IR);

    	/*
    	 * This String will store the returned value from calling the readLine() method
    	 * on BufferedReader object.
    	 */
    	String MESSAGE = BR.readLine();
    	//This String will then be printed. Showing what I got from the client and
    	//displayed in the console where the Server is running.
    	System.out.println(MESSAGE);

    	/*
		 *	If a message is returned we open up the conditional. An instance of the
		 *	PrintStream class is created that passes the returned value of getOutputStream()
		 *	from the SOCK object into PrintStream's Constructor.
		 *	Finally, the println() method on PS is called passing a piece of text as an
		 *	argument.
    	 */

    	if(MESSAGE != null){
    		PrintStream PS = new PrintStream(SOCK.getOutputStream());
    		/* This line will be sent to the client and the person running the client
    		 * will see this message.
    		 */
    		PS.println("MESSAGE received");
    	}
    }
}












