package daoInterfaces;

import objects.Client;

import java.sql.ResultSet;

public interface ClientDao {
    public ResultSet getAllClients();
    public Client getClientID(int ID);
    public void addClient(Client client);
    public void removeClient(int ID);
    public void editClient(Client client);

}
