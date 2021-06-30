package controller;

import daoImpl.ChargeDaoImpl;
import daoImpl.InstalationDaoImpl;
import daoImpl.PaymentDaoImpl;
import objects.Instalation;
import objects.Payment;
import tools.Connector;
import views.InstalationView;
import views.NewPaymentView;
import views.PaymentView;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PaymentController {
    PaymentView view;
    ChargeDaoImpl chargeModel;
    PaymentDaoImpl paymentModel;
    Connector connector;
    public PaymentController(ChargeDaoImpl chargeModel,PaymentDaoImpl paymentModel, Connector connector) {
        this.view = new PaymentView();
        this.chargeModel = chargeModel;
        this.paymentModel = paymentModel;
        this.connector = connector;
        view.getRefreshButton().addActionListener(e-> {
            try {
                refreshTable();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        view.getAddButton().addActionListener(e->addNewPayment());
        view.getEditButton().addActionListener(e->{
            DefaultTableModel tableModel = (DefaultTableModel) view.getPaymentTable().getModel();
            Vector vector = tableModel.getDataVector().elementAt(view.getPaymentTable().getSelectedRow());
            editPayment(vector);
        });
        view.getDeleteButton().addActionListener(e->{
            DefaultTableModel tableModel = (DefaultTableModel) view.getPaymentTable().getModel();
            Vector vector = tableModel.getDataVector().elementAt(view.getPaymentTable().getSelectedRow());
            removePayment(vector);
        });
}

    private void editPayment(Vector vector) {
        NewPaymentView view = new NewPaymentView();
        view.getPrizeField().setText(String.valueOf((Integer) vector.get(1)));
        view.getInstalationIdField().setText(String.valueOf((Integer) vector.get(2)));
        view.getDateField().setText((String) vector.get(3));
        view.getSubmitButton().addActionListener(e->{
            Payment payment = new Payment((Integer) vector.get(0),Integer.parseInt(view.getPrizeField().getText()),Integer.parseInt(view.getInstalationIdField().getText()),view.getDateField().getText());
            paymentModel.editPayment(payment);
            view.frame.dispose();
        });
    }

    private void addNewPayment() {
        NewPaymentView view = new NewPaymentView();
        view.getDateField().setEditable(false);
        view.getSubmitButton().addActionListener(e->{

            Payment payment = new Payment(0,Integer.parseInt(view.getPrizeField().getText()),Integer.parseInt(view.getInstalationIdField().getText())," ");
            paymentModel.addPayment(payment);
            view.frame.dispose();
        });
    }

    private void removePayment(Vector vector) {
        int id = (int) vector.get(0);
        paymentModel.removePayment(id);
    }

    private void refreshTable() throws SQLException {
        ResultSet rs1 = chargeModel.getAllCharges();
       //
        DefaultTableModel chargeModelTable = (DefaultTableModel) view.getChargeTable().getModel();
        DefaultTableModel paymentModelTable = (DefaultTableModel) view.getPaymentTable().getModel();
        chargeModelTable.setColumnCount(0);
        paymentModelTable.setColumnCount(0);
        chargeModelTable.setRowCount(0);
        paymentModelTable.setRowCount(0);
        paymentModelTable.addColumn("ID");
        chargeModelTable.addColumn("ID");
        paymentModelTable.addColumn("Kwota");
        chargeModelTable.addColumn("Kwota");
        paymentModelTable.addColumn("ID Instalacji");
        chargeModelTable.addColumn("ID instalacji");
        paymentModelTable.addColumn("termin płatności");
        chargeModelTable.addColumn("termin płatności");
        while(rs1.next())
        {
            chargeModelTable.addRow(new Object[]{rs1.getInt("ChargeId"),rs1.getInt("Prize"), rs1.getInt("InstalationId"),rs1.getString("ChargeDate")});
        }
        ResultSet rs2 = paymentModel.getAllPayments();
       while(rs2.next())
        {
          paymentModelTable.addRow(new Object[]{rs2.getInt("PaymentId"),rs2.getInt("Prize"), rs2.getInt("InstalationId"),rs1.getString("PaymentDate")});
        }
    }
    }
