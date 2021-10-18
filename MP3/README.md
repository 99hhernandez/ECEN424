## INTRODUCTION
Please read all sections of this document before you begin coding. The purpose of this machine problem is
to familiarize you with network programming. Refer to The Java Tutorials [2] for sample code on how to
create sockets and send messages using them.

## PROBLEM STATEMENT
In this assignment, implement a server and a client using Java sockets. The server and client must use a
TCP connection to communicate with each other.

### SERVER
The server must have the capability to handle multiple clients simultaneously. The server takes as console
input the port number on which clients would connect to it and the maximum number of clients that can
connect simultaneously.

`` >./server <server port> <max. clients> ``

Upon initialization, the server program asks the user to enter a string (str), e.g., “HelloWorld,” and a
positive integer (N). Whenever a client is connected to the server, the server transmits str to the client N
times, with a one-second pause between transmissions. The first N-1 transmissions have no end-of-string or
newline character at the end. The last transmission ends with a newline character.

### CLIENT
The client takes as console input the IP and the port number of the server in order to connect.

`` >./client <server ip> <server port> ``

You will write two versions of the client. The first version, which we call the NaiveClient, displays every
character it receives immediately. The second version, which we call the BufferClient, buffers all incoming
characters and only displays everything when it receives a newline character. Both clients terminate after
receiving and printing the newline character.

## EVALUATION GUIDELINE
1. Test the correctness with one server and one NaiveClient.
2. Test the correctness with one server and one BufferClient.
3. Test whether the server can correctly serve multiple clients simultaneously. Important: “simultaneously” is not the same as “one-by-one.”
