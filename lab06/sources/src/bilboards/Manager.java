package bilboards;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.Duration;
import java.util.Scanner;
public class Manager implements IManager{
    public static IBillboard bindedBillboard;
    ManagerGUI managerGUI = new ManagerGUI();

    @Override
    public int bindBillboard(IBillboard billboard) throws RemoteException {
        bindedBillboard = billboard;

        return 0;
    }

    @Override
    public boolean unbindBillboard(int billboardId) throws RemoteException {
        bindedBillboard = null;
        return false;
    }

    @Override
    public boolean placeOrder(Order order) throws RemoteException {
       /* managerGUI.getCheckButton().addActionListener(e -> {
            try {
                int tab[] = new int[2];
                tab = bindedBillboard.getCapacity();
                String liczba1 = String.valueOf(tab[1]);
                String liczba2 = String.valueOf(tab[0]);
                managerGUI.getAvailablityTextField().setText(liczba1+"/"+liczba2);
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
        });*/
        managerGUI.getAcceptButton().setVisible(true);
        managerGUI.getTextField().setText(order.advertText);
        managerGUI.getAcceptButton().addActionListener(e-> {
            try {
                order.client.setOrderId(Integer.parseInt(managerGUI.getGetIDField().getText()));
                addOrder(order.advertText, order.displayPeriod,managerGUI.getGetIDField().getText(),order.client);
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
        });

        return false;
    }

    private void addOrder(String advertText, Duration displayPeriod, String text, IClient client) throws RemoteException {
        bindedBillboard.addAdvertisement(advertText, displayPeriod, Integer.parseInt(text));
        managerGUI.getAcceptButton().setVisible(false);
    }
    @Override
    public boolean withdrawOrder(int orderId) throws RemoteException {
        managerGUI.getIdField().setText(String.valueOf(orderId));
        managerGUI.getDeleteButton().setVisible(true);
        managerGUI.getDeleteButton().addActionListener(e-> {
            try {
                removeBillboard();
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
        });

        return true;
    }

    private void removeBillboard() throws RemoteException {
        bindedBillboard.removeAdvertisement(Integer.parseInt(managerGUI.getIdField().getText()));
        managerGUI.getDeleteButton().setVisible(false);
    }

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        int port = Integer.parseInt(args[0]);
        Manager manager = new Manager();
        IManager iManager;
        iManager = (IManager) UnicastRemoteObject.exportObject(manager,0);
        Registry registry = LocateRegistry.createRegistry(port);
        registry.rebind("Server"+args[0],iManager);

    }

}
