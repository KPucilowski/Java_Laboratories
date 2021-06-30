package bilboards;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.Duration;

public class Billboard implements IBillboard, Serializable {
    private static BillboardGUI billboardGUI;
    public int port;
    @Override
    public boolean addAdvertisement(String advertText, Duration displayPeriod, int orderId) throws RemoteException {
        if(orderId==1&&billboardGUI.getTextArea1().getText().equals("")){
        billboardGUI.getTextArea1().setText(advertText);
        return true;}
        if(orderId==2&&billboardGUI.getTextArea2().getText().equals("")){
            billboardGUI.getTextArea2().setText(advertText);
        return true;}
        if(orderId==3&&billboardGUI.getTextArea3().getText().equals("")){
            billboardGUI.getTextArea3().setText(advertText);
        return true;}
        if(orderId==4&&billboardGUI.getTextArea4().getText().equals("")){
            billboardGUI.getTextArea4().setText(advertText);
        return true;}
        if(orderId==5&&billboardGUI.getTextArea5().getText().equals("")){
            billboardGUI.getTextArea5().setText(advertText);
            return true;}
        return false;
    }
    public Billboard(int port){
        this.port = port;
    }
    @Override
    public boolean removeAdvertisement(int orderId) throws RemoteException {
        if(orderId==1){
            billboardGUI.getTextArea1().setText("");
            return true;}
        if(orderId==2){
            billboardGUI.getTextArea2().setText("");
            return true;}
        if(orderId==3){
            billboardGUI.getTextArea3().setText("");
            return true;}
        if(orderId==4){
            billboardGUI.getTextArea4().setText("");
            return true;}
        if(orderId==5){
            billboardGUI.getTextArea5().setText("");
            return true;}
        return false;
    }

    @Override
    public int[] getCapacity() throws RemoteException {
        int[] tab = new int[2];
        tab[0]=5;
        tab[1]=0;
        if(billboardGUI.getTextArea1().getText().equals("")){
            tab[1]++;
        }
        if(billboardGUI.getTextArea1().getText().equals("")){
            tab[1]++;
        }
        if(billboardGUI.getTextArea1().getText().equals("")){
            tab[1]++;
        }
        if(billboardGUI.getTextArea1().getText().equals("")){
            tab[1]++;
        }
        if(billboardGUI.getTextArea1().getText().equals("")){
            tab[1]++;
        }
        return tab;
    }

    @Override
    public void setDisplayInterval(Duration displayInterval) throws RemoteException {

    }

    @Override
    public boolean start() throws RemoteException {
        return false;
    }

    @Override
    public boolean stop() throws RemoteException {
        return false;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        int port = Integer.parseInt(args[0]);
        Billboard billboard = new Billboard(port);
        IBillboard iBillboard = (IBillboard) UnicastRemoteObject.exportObject(billboard,0);
        Registry registry = LocateRegistry.createRegistry(port);
        registry.rebind("Server"+args[0],iBillboard);
        billboardGUI = new BillboardGUI();
        billboardGUI.getBindButton().addActionListener(e->{
            int managerPort= Integer.parseInt(billboardGUI.getPortField().getText());
            try {
                IManager managerReply = (IManager) LocateRegistry.getRegistry("localhost", managerPort)
                        .lookup("Server"+managerPort);
                managerReply.bindBillboard(billboard);
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            } catch (NotBoundException notBoundException) {
                notBoundException.printStackTrace();
            }
        });
    }

}
