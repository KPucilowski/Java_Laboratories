package controller;

import daoImpl.InstalationDaoImpl;
import daoImpl.ServiceDaoImpl;
import objects.Instalation;
import objects.Service;
import tools.Connector;
import views.InstalationView;
import views.NewInstalationView;
import views.NewServiceView;
import views.ServiceView;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class InstalationController {
    InstalationView view;
    InstalationDaoImpl instalationModel;
    Connector connector;

    public InstalationController(InstalationDaoImpl instalationModel, Connector connector) {
        this.view = new InstalationView();
        this.instalationModel = instalationModel;
        this.connector = connector;
        view.getRefreshButton().addActionListener(e-> {
            try {
                refreshTable();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        view.getAddInstalationButton().addActionListener(e->{
            addNewInstalation();
        });
        view.getDeleteInstalationButton().addActionListener(e->{
            DefaultTableModel tableModel = (DefaultTableModel) view.getInstalationTable().getModel();
            Vector vector = tableModel.getDataVector().elementAt(view.getInstalationTable().getSelectedRow());
            removeInstalation(vector);
        });
        view.getEditInstalationButton().addActionListener(e->{
            DefaultTableModel tableModel = (DefaultTableModel) view.getInstalationTable().getModel();
            Vector vector = tableModel.getDataVector().elementAt(view.getInstalationTable().getSelectedRow());
            editInstalation(vector);
        });
    }

    private void editInstalation(Vector vector) {
        NewInstalationView view = new NewInstalationView();
        view.getIdField().setText(String.valueOf((Integer) vector.get(0)));
        view.getAdressField().setText((String) vector.get(1));
        view.getRouterNumberField().setText(String.valueOf((Integer) vector.get(2)));
        view.getServiceField().setText((String) vector.get(3));
        view.getClientIDField().setText(String.valueOf((Integer) vector.get(4)));
        view.getSubmitButton().addActionListener(e->{
            Instalation instalation = new Instalation(Integer.parseInt(view.getIdField().getText()),view.getAdressField().getText(),Integer.parseInt(view.getRouterNumberField().getText()),view.getServiceField().getText(),Integer.parseInt(view.getClientIDField().getText()));
            instalationModel.editInstalation(instalation);
            view.frame.dispose();
        });
    }

    private void addNewInstalation() {
        NewInstalationView view = new NewInstalationView();
        view.getSubmitButton().addActionListener(e->{
            Instalation instalation = new Instalation(Integer.parseInt(view.getIdField().getText()),view.getAdressField().getText(),Integer.parseInt(view.getRouterNumberField().getText()),view.getServiceField().getText(),Integer.parseInt(view.getClientIDField().getText()));
            instalationModel.addInstalation(instalation);
            view.frame.dispose();
        });
    }

    private void removeInstalation(Vector vector) {
        int id = (int) vector.get(0);
        instalationModel.removeInstalation(id);
    }

    private void refreshTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) view.getInstalationTable().getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("ID instalacji");
        model.addColumn("adres");
        model.addColumn("numer routera");
        model.addColumn("usługa");
        model.addColumn("ID klienta");
        ResultSet rs = instalationModel.getAllInstalations();
        while(rs.next())
        {
            model.addRow(new Object[]{rs.getInt("InstalationId"), rs.getString("Adress"),rs.getInt("RouterNumber"),rs.getString("Service"),rs.getInt("ClientID")});
        }
    }
}
