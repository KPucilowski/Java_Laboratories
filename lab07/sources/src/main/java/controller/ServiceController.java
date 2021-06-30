package controller;

import daoImpl.ClientDaoImpl;
import daoImpl.ServiceDaoImpl;
import objects.Service;
import tools.Connector;
import views.ClientView;
import views.NewServiceView;
import views.ServiceView;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ServiceController {
    ServiceView view;
    ServiceDaoImpl serviceModel;
    Connector connector;

    public ServiceController(ServiceDaoImpl serviceModel, Connector connector) {
        this.view = new ServiceView();
        this.serviceModel = serviceModel;
        this.connector = connector;
        view.getRefreshButton().addActionListener(e-> {
            try {
                refreshTable();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        view.getAddServiceButton().addActionListener(e->{
            addNewService();
        });
        view.getDeleteInstalatoinButton().addActionListener(e->{
            DefaultTableModel tableModel = (DefaultTableModel) view.getServiceTable().getModel();
            Vector vector = tableModel.getDataVector().elementAt(view.getServiceTable().getSelectedRow());
            removeService(vector);
        });
        view.getEditServiceButton().addActionListener(e->{
            DefaultTableModel tableModel = (DefaultTableModel) view.getServiceTable().getModel();
            Vector vector = tableModel.getDataVector().elementAt(view.getServiceTable().getSelectedRow());
            editService(vector);
        });
    }

    private void editService(Vector vector) {
        NewServiceView view = new NewServiceView();
        view.getIdField().setText(String.valueOf((Integer) vector.get(0)));
        view.getPrizeField().setText(String.valueOf((Integer) vector.get(1)));
        view.getServiceTypeField().setText((String) vector.get(2));
        view.getSubmitButton().addActionListener(e->{
            Service service = new Service(Integer.parseInt(view.getIdField().getText()),Integer.parseInt(view.getPrizeField().getText()),view.getServiceTypeField().getText());
            serviceModel.editService(service);
            view.frame.dispose();
        });
    }

    private void removeService(Vector vector) {
        int id = (Integer) vector.get(0);
        serviceModel.removeService(id);
    }

    private void addNewService() {
        NewServiceView view = new NewServiceView();
        view.getSubmitButton().addActionListener(e->{
            Service service = new Service(Integer.parseInt(view.getIdField().getText()),Integer.parseInt(view.getPrizeField().getText()),view.getServiceTypeField().getText());
            serviceModel.addService(service);
            view.frame.dispose();
        });
    }

    private void refreshTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) view.getServiceTable().getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("ID");
        model.addColumn("Cena");
        model.addColumn("Usługa");
        ResultSet rs = serviceModel.getAllServices();
        while(rs.next())
        {
            model.addRow(new Object[]{rs.getInt("ServiceID"),rs.getInt("Prize"), rs.getString("ServiceType")});
        }
    }


}