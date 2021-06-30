package app;

import lib.Client;

import java.io.IOException;

public class MainController {
    public MainController(){
        MainView view = new MainView();
        init(view);
    }

    private void init(MainView view) {
        view.getStartServerButton().addActionListener(e->{
            int serverPort = Integer.parseInt(view.getServerPortField().getText());
            ServerThread m1=new ServerThread(serverPort);
            Thread t1 =new Thread(m1);
            t1.start();
        });
        view.getConnectButton().addActionListener(e->{
            int clientPort = Integer.parseInt(view.getClientPortField().getText());
            String clientName = view.getNameField().getText();
            Client client = new Client("localhost",clientPort,clientName);
            view.getSendButton().addActionListener(e2->{
                String message = view.getMessageField().getText();
                try {
                    client.sendMessage(message,clientName);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        });
    }
}
