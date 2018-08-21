Information on Client Server Architecture using Java:

In Java, we can create two applications: a server and a client.
A Server application provides services such as accessing a Database, providing
authentication and access to shared resources.
Client Applications are created to make use of the server's services.

To create a 'point to point' client-server connection we use Transmission Control 
Protocol, aka TCP. This is known as a 'reliable' protocol and guarantees the delivery
of data in the form of 'packets'.
If a packet is damaged, the TCP will resend the data until it can verify that the
Packet has been successfully transmitted.
Applications that use TCP include those that need a perfect transfer of data, such as
file sharing.

TCP/IP Sockets:
When creating a connection, a client and server each bind a "socket" to the end of their
connection. Once connected, the client and server can both read from and write to the
socket when communicating.

A socket is created using an IP address and a port number. The socket can be viewed as
the end-point of the two communication link between client and server when sending 
Packets to each other. 
A client and server can have multiple TCP connections, each unique by its combination
of ports and end-points.

The server runs on a specific host where it creates and continuously listens to a 
"server socket" that is bound to a specified port number and then waits for the
client to make connection request.
The client must know the correct Port and IP Address/host name of the server to create
a connection request and identify itself. 
When the server accepts the client's connection request, the client creates its socket
and communication between client and server can take place. This is done in the form of
reading from and writing to their sockets.

In Java:
Java uses the Socket and ServerSocket classes from the java.net package to create client-
server communication.

In the server application (server.java), once a ServerSocket has been instantiated (i.e.
created into an object) with a port, a new Socket object is created to accept the ServerSocket's connection by calling the accept() method on the ServerSocket object.
Following this, an InputStreamReader, BufferedReader and PrintStream class objects are
Created.
The BufferedReader object's readLine() method is used to retrieve input from the client.
The PrintStream object's println() method is used to send an output to the client.

In the client application (client.java) a new Socket object is created if the server's ServerSocket object accepts the connection request.
The connection is requested by instantiating a Socket class object and passing in the 
Server's IP, hostname and the selected port as arguments.
Then the InputStreamReader, BufferedReader and PrintStream class objects are instantiated.
The BufferedReader object's readLine() method is used to retrieve input from the server.
The PrintStream object's println() method is used to send an output to the server.

Summary:
- Create a Socket or ServerSocket object and open it over a specified port and IP address or hostname.
- Instantiate InputStreamReader, BufferedReader and PrintStream objects to stream data to and from each socket.
- Read from and write to the stream between the sockets using their agreed upon protocol.
- Close the input and output streams.
- Close the Socket and ServerSocket objects.


 








