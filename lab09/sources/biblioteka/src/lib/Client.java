package lib;

import javax.swing.*;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public Socket socket;
    public Client(String address, int port,String name) {

        try {
            socket = new Socket(address, port);
            ServerConnection connection = new ServerConnection(socket);
            new Thread(connection).start();
        } catch (UnknownHostException e) {
            System.out.println(e);
            System.out.println("Could not connect! Reason: " + e);
        } catch (IOException e) {
            System.out.println("Could not connect! Reason: " + e);
        }

    }
    public void sendMessage(String message,String name) throws IOException {
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        try {
            output.writeUTF(name+": "+message+"\n");
            output.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
