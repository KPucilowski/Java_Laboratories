package objects;

import java.sql.ResultSet;

public class Instalation {
    int InstalationID;
    String Adress;
    int RouterNumber;
    String Service;
    int ClientId;
    public Instalation(int instalationID, String adress, int routerNumber, String service, int clientId) {
        InstalationID = instalationID;
        Adress = adress;
        RouterNumber = routerNumber;
        Service = service;
        ClientId = clientId;
    }

    public int getInstalationID() {
        return InstalationID;
    }



    public String getAdress() {
        return Adress;
    }



    public int getRouterNumber() {
        return RouterNumber;
    }



    public String getService() {
        return Service;
    }



    public int getClientId() {
        return ClientId;
    }


}
