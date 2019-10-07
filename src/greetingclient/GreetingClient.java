/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingclient;

import com.sun.org.apache.bcel.internal.util.ByteSequence;
import java.io.*;
import java.net.*;

/**
 *
 * @author Abdelhalim
 */
public class GreetingClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String serverName = "localhost";
        int port = 6066;
        
        try{
            System.out.println("Connecting to... "+serverName+" on port" +port);
            Socket client = new Socket(serverName, port);
            System.out.println("Just Connected to "+
                    client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream dataOut = new DataOutputStream(outToServer);
            dataOut.writeUTF("Hello From "+
                    client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream dataIn = new DataInputStream(inFromServer);
            System.out.println("Server says "+
                    dataIn.readUTF());
            client.close();
        }catch(IOException ioExp){
            ioExp.printStackTrace();
        }
    }
}
