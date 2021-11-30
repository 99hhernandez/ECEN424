import java.io.*;
import java.net.*;

import javax.sound.sampled.Port;

// basic UDP server
/*
class UDPServer {
    public static void main(String args[]) throw Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        
        while(true) {
            DatagramPacket receivePacket = newDatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length(), IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
*/

public class Talker {
    public static void main(String args[]) {
        if(args.length != 2) {
            System.out.println("Port, Message");
            return;
        }
        try {
            int Port = Integer.parseInt(args[0]);
            String fullMessage = args[1];

            if(fullMessage.length() > 50) {
                throw new Exception("Message too large.");
            }

            String[] splitMessages = fullMessage.split("(?<=\\G.{10})");

            DatagramSocket serverSocket = new DatagramSocket(Port);
            System.out.print("Server is ready....");
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            for(int i = 0; i < splitMessages.length; i++) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                System.out.println(receivePacket.getAddress() + " " + receivePacket.getPort() + ": " + receivePacket.getData());
                //serverSocket.send(packet);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}