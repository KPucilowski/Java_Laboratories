package daoImpl;

import daoInterfaces.ClientDao;
import objects.Client;
import tools.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDaoImpl implements ClientDao {
    @Override
    public ResultSet getAllClients() {
        try {
            ResultSet rs = Connector.statement.executeQuery("select * from Client");
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Client getClientID(int ID) {
        try {
            ResultSet rs = Connector.statement.executeQuery("select * from Client where ID = "+ID+";");
            Client client = new Client(rs.getInt("ID"),rs.getString("FirstName"),rs.getString("LastName"));

            return client;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void addClient(Client client){
        String sql = "INSERT INTO Client(ID, FirstName,LastName) VALUES(?,?,?)";

        try{
            PreparedStatement pstmt = Connector.connection.prepareStatement(sql);
            pstmt.setInt(1, client.getID());
            pstmt.setString(2, client.getFirstName());
            pstmt.setString(3, client.getLastName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeClient(int ID) {
        try {
            Connector.statement.executeUpdate("delete from Client where ID="+ID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editClient(Client client) {
        String sql = "UPDATE Client SET FirstName = (?) ,LastName = (?) where ID = (?)";

        try{
            PreparedStatement pstmt = Connector.connection.prepareStatement(sql);
            pstmt.setInt(3, client.getID());
            pstmt.setString(1, client.getFirstName());
            pstmt.setString(2, client.getLastName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
