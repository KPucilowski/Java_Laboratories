package daoImpl;

import daoInterfaces.ServiceDao;
import objects.Client;
import objects.Service;
import tools.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceDaoImpl implements ServiceDao {
    @Override
    public ResultSet getAllServices() {
        try {
            ResultSet rs = Connector.statement.executeQuery("select * from Service");
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Service getServicesID(int ID) {
        try {
            ResultSet rs = Connector.statement.executeQuery("select * from Service where ServiceID = "+ID+";");
            Service service = new Service(rs.getInt("ServiceID"),rs.getInt("Prize"),rs.getString("ServiceType"));
            return service;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void addService(Service service) {
        String sql = "INSERT INTO Service(ServiceId, Prize,ServiceType) VALUES(?,?,?)";

        try{
            PreparedStatement pstmt = Connector.connection.prepareStatement(sql);
            pstmt.setInt(1, service.getServiceId());
            pstmt.setInt(2, service.getPrize());
            pstmt.setString(3, service.getServiceType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeService(int ID) {
        try {
            Connector.statement.executeUpdate("delete from Service where ServiceId="+ID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editService(Service service) {
        String sql = "UPDATE Service SET Prize = (?) ,ServiceType = (?) where ServiceId = (?)";

        try{
            PreparedStatement pstmt = Connector.connection.prepareStatement(sql);
            pstmt.setInt(3, service.getServiceId());
            pstmt.setInt(1, service.getPrize());
            pstmt.setString(2, service.getServiceType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
