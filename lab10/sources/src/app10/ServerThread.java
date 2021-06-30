package app;

import lib.Server;

public class ServerThread implements Runnable{
    public int port;

    public ServerThread(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        Server server = new Server(port);
    }
}
