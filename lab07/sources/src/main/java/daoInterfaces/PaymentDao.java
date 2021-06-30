package daoInterfaces;

import objects.Payment;

import java.sql.ResultSet;

public interface PaymentDao {
    public ResultSet getAllPayments();
    public void removePayment(int id);
    public void editPayment(Payment payment);
    public void addPayment(Payment payment);
}
