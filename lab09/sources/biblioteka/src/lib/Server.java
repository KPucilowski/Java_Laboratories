package lib;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private Socket socket = null;
    private Socket socket2 = null;
    private ServerSocket server = null;
    private ExecutorService pool = Executors.newFixedThreadPool(4);
    private List<Socket> sockets= new ArrayList();

    public Server (int port) {
        JFrame frame = new JFrame("chat");
        JPanel panel = new JPanel();
        JTextArea field = new JTextArea();
        field.setEditable(false);
        field.setSize(100,100);
        panel.add(field);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        try {
            server = new ServerSocket(port);
            System.out.println("server is on");
            int i = 0;
            while (true) {
                socket = server.accept();
                ConnectionHandler clientThread = new ConnectionHandler(socket,field);
                System.out.println("new client accepted");
                pool.execute(clientThread);

            }


        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}