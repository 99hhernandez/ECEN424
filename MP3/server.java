import java.io.*;
import java.net.*;

class TCPServer{
    public static void main(String argv[]) throws Exception{
        try {
            String serverMessage;       //server message sent to client upon connection
            ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(argv[0]));

            while(true) {

            }
        }
        catch(NumberFormatException e) {
            System.out.println("One of the numbers entered was not an integer. Enter an integer and try again.");
        }
    }
}
