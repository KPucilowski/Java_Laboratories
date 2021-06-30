package lib;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ConnectionHandler implements Runnable {
    private Socket client;
    private DataInputStream in;
    private List<DataInputStream> ins = new ArrayList();
    private DataOutputStream out;
    private List<DataOutputStream> outs = new ArrayList();
    private JTextArea field;
    public ConnectionHandler(Socket socket,JTextArea field) throws IOException {
        this.client = socket;
        this.field = field;
            in = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));

    }

    @Override
    public void run() {

        try {
            String message = "";
            while (!message.equals("/stop")) {
                    message = in.readUTF();
                    sendMessage(message,field);
            }

        } catch (IOException e) {
            System.err.println("IO exception in connection handler!");
            System.err.println(e.getStackTrace());
        } finally {
            try {

                    out.close();


                    in.close();



            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void sendMessage(String message,JTextArea field) throws IOException {
            field.append(message);
        }


}
