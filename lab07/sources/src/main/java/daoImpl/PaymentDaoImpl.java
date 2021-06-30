package daoImpl;

import daoInterfaces.PaymentDao;
import objects.Payment;
import tools.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDaoImpl implements PaymentDao {
    @Override
    public ResultSet getAllPayments() {
        try {
            ResultSet rs = Connector.statement.executeQuery("select * from Payment");
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void removePayment(int id) {
        try {
            Connector.statement.executeUpdate("delete from Payment where PaymentId="+id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editPayment(Payment payment) {
        String sql = "UPDATE Payment SET Prize = (?) ,InstalationId = (?),PaymentDate = (?) where PaymentId = (?)";

        try{
            PreparedStatement pstmt = Connector.connection.prepareStatement(sql);
            pstmt.setInt(4, payment.getPaymentId());
            pstmt.setInt(1, payment.getPrize());
            pstmt.setInt(2, payment.getInstalationId());
            pstmt.setString(3, payment.getPaymentDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addPayment(Payment payment) {
        String sql = "INSERT INTO Payment(PaymentId, Prize,InstalationId,PaymentDate) VALUES(null,?,?,date('now'))";

        try{
            PreparedStatement pstmt = Connector.connection.prepareStatement(sql);
            pstmt.setInt(1, payment.getPrize());
            pstmt.setInt(2, payment.getInstalationId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
