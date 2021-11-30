import java.io.*;
import java.net.*;

class NaiveClient {
    public static void main(String argv[]) throws Exception {
        try {
            String hostname = argv[0];
            int port = Integer.parseInt(argv[1]);
            String userMessage, serverMessage;

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));       //create input stream
            Socket clientSocket = new Socket(hostname, port);        //create client socket to connect to server
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());        // create output stream attached to socket
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));        //create input stream attached to socket
            serverMessage = inFromServer.readLine();
            System.out.println("RECEIVED FROM SERVER: " + serverMessage);    //Read and print line from server

            while(true) {
                userMessage = inFromUser.readLine();
                if(userMessage.equals("q")) {
                    outToServer.writeBytes("Client is down..." + '\n');
                    break;
                }
                outToServer.writeBytes(userMessage + '\n');
                outToServer.flush();        //flush output stream and force buffer output bytes to be written 
            }
            outToServer.close();
            inFromServer.close();
            outToServer.close();
            clientSocket.close();
        }
        catch(NumberFormatException e) {
            System.out.println("Please enter an integer for the port number.");
        }
        catch(UnknownHostException e) {
            System.out.println("Please enter a valid IP address.");
        }
    }
}
/*
class BufferClient {
    public static void main(String argv[]) throws Exception {
        try {
            String hostname = argv[0];
            int port = Integer.parseInt(argv[1]);


        }
        catch(NumberFormatException e) {
            System.out.println("Please enter an integer for the port number.");
        }
        catch(UnknownHostException e) {
            System.out.println("Please enter a valid IP address.");
        }
    }
}
*/