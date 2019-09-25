//package twoC;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


/*
For sending a packet via UDP, we should know 4 things, 
the message to send, its length, ipaddress of destination, 
port at which destination is listening.

Once we know all these things, we can create the socket object 
for carrying the packets and packets which actually possess the data.

Invoke send()/receive() call for actually sending/recieving packets.

Extract the data from the received packet.*/



//server need to set the port number

public class Rfc865UdpServer {
	 public static void main(String[] args) throws IOException 
	    { 
	        // Step 1 : Create a socket to listen at port 17 
	        DatagramSocket ds = new DatagramSocket(17); 
	        byte[] receive = new byte[65535]; 
	        byte[] reply =new byte [65535];
	  
	        Scanner sc = new Scanner(System.in);
	        DatagramPacket DpReceive = null; 
	        while (true) 
	        { 
	  
	            // Step 2 : create a DatgramPacket to receive the data. 
	            DpReceive = new DatagramPacket(receive, receive.length); 
	  
	            // Step 3 : revieve the data in byte buffer. 
	            ds.receive(DpReceive); 
	  
	            System.out.println("Client:-" + data(receive));
	            
	            
	            // Step 4 :give client feedback
	            //find the ip address and port of client,they can be found in the packet from client
	            
	            InetAddress clientAddress=DpReceive.getAddress();
	            int clientport=DpReceive.getPort();
	            
	            //information u are willing to tell client
	            String inp = sc.nextLine();
	            reply = inp.getBytes();
	            
	            //group them into data packet
	            DatagramPacket DpReply=new DatagramPacket(reply,reply.length,clientAddress,clientport);    
	            ds.send(DpReply);
	            // Exit the server if the client sends "bye" 
/*	            if (data(receive).toString().equals("bye")) 
	            { 
	                System.out.println("Client sent bye.....EXITING"); 
	                break; 
	            }
	  */
	            // Clear the buffer after every message. 
	            receive = new byte[65535]; 
	            reply = new byte[65535];
	        }
	    }
	     
	        // A utility method to convert the byte array 
	        // data into a string representation. 
	        public static StringBuilder data(byte[] a) 
	        { 
	            if (a == null) 
	                return null; 
	            StringBuilder ret = new StringBuilder(); 
	            int i = 0; 
	            while (a[i] != 0) 
	            { 
	                ret.append((char) a[i]); 
	                i++; 
	            } 
	            return ret; 
	        } 
}
