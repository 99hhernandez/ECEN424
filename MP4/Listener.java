import java.io.*;
import java.net.*;

//basic UDP client
/*
class UDPClient {
    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("hostname");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivedPacket.getData());
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    }
}
*/

public class Listener {
    public static void main(String args[]) {
        if(args.length != 2) {                                                  //checking for valid arguments
            System.out.println("Hostname, Port");
            return;
        }
        DatagramSocket clientSocket = null;

        try {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            InetAddress Hostname = InetAddress.getByName(args[0]);              //translating host to IP address
            int Port = Integer.parseInt(args[1]);                               //converting port number to integer

            clientSocket = new DatagramSocket();                                //socket construct
            
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, Hostname, Port);
            clientSocket.send(sendPacket);
            clientSocket.setSoTimeout(2000);                                    //set 2s receive timeout

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData());
            System.out.println("FROM SERVER: " + modifiedSentence);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            if(clientSocket != null) {
                clientSocket.close();
            }
        }
    }
}