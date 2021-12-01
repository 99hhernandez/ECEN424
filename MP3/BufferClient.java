import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferClient{
    public static void main(String[] args){
        String serverIP = args[0];
        int serverPort = Integer.parseInt(args[1]);
        
        System.out.println("The chosen IP address is: " + serverIP);
        System.out.println("The chosen port number is: " + args[1]);
        try(
            Socket clientSocket = new Socket("127.0.0.1", serverPort); //creating socket to connect to server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); //reads userInput
            //writing request
            PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream(), true); //this true was the reason I got an error

            BufferedReader clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println(clientIn.readLine()); //getting sentence request from server
            clientOut.println(userInput.readLine()); //entering sentence
            System.out.println(clientIn.readLine()); //getting number request from server
            String numStr = userInput.readLine();
            int n = Integer.parseInt(numStr);
            clientOut.println(numStr); //entering number

            String result = "";
            for(int i = 0; i < n; i++){
                result += clientIn.readLine(); //displays everything after the end newline is found
            }
            System.out.println(result);
            clientSocket.close();
        }
        catch(IOException e){
            System.out.print("Failed to create socket");
        }
    }
} 