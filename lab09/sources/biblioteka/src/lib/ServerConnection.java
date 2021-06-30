package lib;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection implements Runnable {

    @SuppressWarnings("unused")
    private Socket socket;
    private DataInputStream in;

    public ServerConnection(Socket socket) throws IOException {
        this.socket = socket;
        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    }

    @Override
    public void run() {
        while (true) {
            String message;
            try {
                message = in.readUTF();
                System.out.println(message);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }

}