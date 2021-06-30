package daoImpl;

import daoInterfaces.InstalationDao;
import objects.Client;
import objects.Instalation;
import tools.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstalationDaoImpl implements InstalationDao {
    @Override
    public ResultSet getAllInstalations() {
        try {
            Connector connector = new Connector();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ResultSet rs = Connector.statement.executeQuery("select * from Instalation");
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Instalation getInstalationID(int ID) {
        try {
            ResultSet rs = Connector.statement.executeQuery("select * from Instalation where InstalationId = "+ID+";");
            Instalation instalation = new Instalation(rs.getInt("InstalationId"),rs.getString("Address"),rs.getInt("RouterNumber"),rs.getString("Service"),rs.getInt("ClientId"));
            return instalation;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void addInstalation(Instalation instalation) {
        String sql = "INSERT INTO Instalation(InstalationId, Adress,RouterNumber,Service,ClientId) VALUES(?,?,?,?,?)";

        try{
            PreparedStatement pstmt = Connector.connection.prepareStatement(sql);
            pstmt.setInt(1, instalation.getInstalationID());
            pstmt.setString(2, instalation.getAdress());
            pstmt.setInt(3, instalation.getRouterNumber());
            pstmt.setString(4, instalation.getService());
            pstmt.setInt(5, instalation.getClientId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String sql2 = "INSERT INTO Charge(ChargeId, Prize,InstalationId,ChargeDate) VALUES(null,?,?,date('now','+1 month','-1 day'))";
        String sql3 = "SELECT Prize from Service where ServiceType = (?)";
        int prize;
        try {
            PreparedStatement pstmt2 = Connector.connection.prepareStatement(sql3);
            pstmt2.setString(1, instalation.getService());
            ResultSet rs = pstmt2.executeQuery();
            prize = rs.getInt(1);

            PreparedStatement pstmt3 = Connector.connection.prepareStatement(sql2);
            pstmt3.setInt(2,instalation.getInstalationID());
            pstmt3.setInt(1, prize);
            pstmt3.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void removeInstalation(int ID) {
        try {
            Connector.statement.executeUpdate("delete from Instalation where InstalationId="+ID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editInstalation(Instalation instalation) {
        String sql = "UPDATE Instalation SET Adress = (?) ,RouterNumber = (?),Service = (?),ClientId = (?) where InstalationId = (?)";

        try{
            PreparedStatement pstmt = Connector.connection.prepareStatement(sql);
            pstmt.setInt(5, instalation.getInstalationID());
            pstmt.setString(1, instalation.getAdress());
            pstmt.setInt(2, instalation.getRouterNumber());
            pstmt.setString(3, instalation.getService());
            pstmt.setInt(4, instalation.getClientId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
