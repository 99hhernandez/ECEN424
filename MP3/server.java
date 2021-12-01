import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class server {
    
    static int portNumber = 0;
    public static void main(String[] args) throws IOException{

        if (args.length != 2) {
            System.err.println("Usage: java KnockKnockServer <port number>");
            System.exit(1);
        }
 
        portNumber = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(portNumber);
        int maxClients = Integer.parseInt(args[1]);
        int currentClients = 0;
        Vector<Thread> threads = new Vector<Thread>();
        while(true){
            if(currentClients < maxClients){
                Socket clientSocket = serverSocket.accept();
                threads.add(new Thread(new ClientHandler(clientSocket)));
                threads.elementAt(threads.size()-1).start();
                currentClients += 1;
            }else if(currentClients == maxClients){
                for(int i = 0; i < currentClients; i++){
                    if(threads.elementAt(i).isAlive() == false){
                        threads.remove(i);
                        currentClients -= 1;
                        i--;
                        System.out.println("Client ended!");
                    }
                }
            }
        }

    }
}
