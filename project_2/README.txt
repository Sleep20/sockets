In this assignment, we are going to create a SocketServer that is multi-threaded.
A client will connect to the Server to perform some Mortgage calculation and the server will send back the figure for their monthly repayment.
The client will provide three pieces of information:
- Annual % Rate
- The loan amount
- The loan duration

All the processing will happen on the server in a separate thread and we will reply to the client the monthly repayment amount.



