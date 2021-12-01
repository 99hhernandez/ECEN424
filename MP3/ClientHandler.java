import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    Socket clientSocket;


    public ClientHandler(){
    }
    public ClientHandler(Socket clientSock){
        clientSocket = clientSock;
    }
    public void run(){
        try(
            BufferedReader serverIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter serverOut = new PrintWriter(clientSocket.getOutputStream(), true);
        )
        {
            String inputLine;
            int n;

            serverOut.println("Please enter a sentence: ");
            inputLine = serverIn.readLine();
            serverOut.println("Now enter a number n: ");
            n = Integer.parseInt(serverIn.readLine());

            for(int i = 0; i < n; i++){
                serverOut.println(inputLine);
                try {
                    Thread.sleep(1000);
                 } catch (InterruptedException e){
                     System.out.println("Thread electric.");
                 }

            }
            
        } catch (IOException e){
            System.out.println("Problem serving more than 1 client");
        }
    }
}
