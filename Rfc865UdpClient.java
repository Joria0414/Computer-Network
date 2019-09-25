//package twoClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*Note:- In order to test the above programs on the system, 
Please make sure that you run the server program first and 
then the client one. 

Make sure you are in the client console and from there keep on 
typing your messages each followed with a carriage return.
 
Every time you send a message you will be redirected to the server 
console depending on your environment settings. 

If not redirected automatically, switch to server console to make sure 
all your messages are received. 

Finally to terminate the communication, type "bye" (without quotes) and hit enter.*/


//server can know the exact info of client through the data packet it received 
		
public class Rfc865UdpClient {
	 public static void main(String args[]) throws IOException 
	    { 
	        Scanner sc = new Scanner(System.in); 
	  
	        // Step 1:Create the socket object for 
	        // carrying the data. 
	        DatagramSocket ds = new DatagramSocket(); 
	  
	        InetAddress ip = InetAddress.getLocalHost(); 
	        byte bufsend[] = new byte[65535];
	        byte bufreceive[] = new byte [65535];
	  
	        // loop while user not enters "bye" 
	        while (true) 
	        { 
	            String inp = sc.nextLine(); 
	  
	            // convert the String input into the byte array. 
	            bufsend = inp.getBytes(); 
	  
	            // Step 2 : Create the datagramPacket for sending 
	            // the data. 
	            DatagramPacket DpSend = 
	                  new DatagramPacket(bufsend, bufsend.length, ip, 17); 
	  
	            // Step 3 : invoke the send call to actually send 
	            // the data. 
	            ds.send(DpSend); 
	  
	            //Step 4: receive the server's feedback
	            
	            //set which buffer the packet will go and receive
	            DatagramPacket DpRecieve = new DatagramPacket(bufreceive,bufreceive.length);
	            ds.receive(DpRecieve);
	            
	            //using data() change byte into string and print out
	            System.out.println("server:-"+data(bufreceive));
	            
	       /*     // break the loop if user enters "bye" 
	            if (inp.equals("bye")) 
	                break; */
	        } 
	    } 
	 
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
