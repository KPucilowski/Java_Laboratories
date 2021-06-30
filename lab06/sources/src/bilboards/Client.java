package bilboards;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.Duration;

public class Client implements IClient, Serializable {
    private static ClientGUI clientGUI;
    private static int orderID;
    public int host;
    public int port;
    public String name;
    @Override
    public void setOrderId(int orderId) throws RemoteException {
        orderID=orderId;
        clientGUI.getIdTextField().setText(String.valueOf(orderId));
    }

    public Client(int host, int port, String name) {
        this.host = host;
        this.port = port;
        this.name = name;
    }

    public static void main(String[] args) throws RemoteException {
        IManager managerReply;
        int port = Integer.parseInt(args[0]);
        int host = port;
        String name="Server"+args[0];
        Client client = new Client(host,port,name);
        IClient iclient = (IClient) UnicastRemoteObject.exportObject(client,0);
        Registry registry = LocateRegistry.createRegistry(port);
        registry.rebind("Server"+args[0],iclient);
        initGUI(port,iclient);
    }

    private static void initGUI(int port, IClient iclient) {
        clientGUI = new ClientGUI();
        clientGUI.getClientPort().setText(String.valueOf(port));
        clientGUI.getGetManagerButton().addActionListener(e -> {
            int managerPort = Integer.parseInt(clientGUI.getManagerPort().getText());
            try {
                IManager managerReply = (IManager) LocateRegistry.getRegistry("localhost", managerPort)
                            .lookup("Server"+managerPort);
                clientGUI.getSendBoardButton().addActionListener(e1->{
                    Order order = new Order(clientGUI.getTextField().getText(),Duration.ofSeconds(Long.parseLong(clientGUI.getTimeField().getText())),iclient);
                    try {
                        managerReply.placeOrder(order);
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                    clientGUI.getIdTextField().setText(String.valueOf(orderID));
                });

                clientGUI.getRemoveBoardButton().addActionListener(e2->{
                    try {
                        managerReply.withdrawOrder(Integer.parseInt(clientGUI.getIdTextField().getText()));
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                });
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            } catch (NotBoundException notBoundException) {
                notBoundException.printStackTrace();
            }

        });

    }
}
