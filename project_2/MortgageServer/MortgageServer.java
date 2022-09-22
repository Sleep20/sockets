import java.io.*;
import java.net.*;
/*
 * This file activates the Server by creating an instance of it and calling the runServer()
 * method which repeatedly looks for interaction.
 */

public class MortgageServer{

	public static void main(String [] args){
		
		System.out.println("Hello Server");
		SocketServer s = new SocketServer();
		try {
			s.runServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}