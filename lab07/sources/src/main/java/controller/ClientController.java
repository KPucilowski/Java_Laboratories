package controller;

import daoImpl.ClientDaoImpl;
import daoImpl.ServiceDaoImpl;
import objects.Client;
import objects.Service;
import tools.Connector;
import views.ClientView;
import views.NewClientView;
import views.NewServiceView;
import views.ServiceView;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ClientController {
    ClientView view;
    ClientDaoImpl clientModel;
    Connector connector;

    public ClientController(ClientDaoImpl clientModel, Connector connector) {
        this.view = new ClientView();
        this.clientModel = clientModel;
        this.connector = connector;
        view.getRefreshButton().addActionListener(e-> {
            try {
                refreshTable();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        view.getAddClientButton().addActionListener(e->addNewClient());
        view.getDeleteClientButton().addActionListener(e->{
                    DefaultTableModel tableModel = (DefaultTableModel) view.getClientTable().getModel();
                    Vector vector = tableModel.getDataVector().elementAt(view.getClientTable().getSelectedRow());
                    deleteClient(vector);
                }
                );
        view.getEditClientButton().addActionListener(e-> {
            DefaultTableModel tableModel = (DefaultTableModel) view.getClientTable().getModel();
            Vector vector = tableModel.getDataVector().elementAt(view.getClientTable().getSelectedRow());
            editClient(vector);
        });

    }

    private void editClient(Vector vector) {

        NewClientView view = new NewClientView();
        view.getIdField().setText(String.valueOf((Integer) vector.get(0)));
        view.getFirstNameField().setText((String) vector.get(1));
        view.getLastNameField().setText((String) vector.get(2));
        view.getSubmitButton().addActionListener(e->{
            Client client = new Client(Integer.parseInt(view.getIdField().getText()),view.getFirstNameField().getText(),view.getLastNameField().getText());
            clientModel.editClient(client);
            view.frame.dispose();
        });
    }

    private void deleteClient(Vector vector) {
        int id = (int) vector.get(0);
        clientModel.removeClient(id);
    }

    private void addNewClient() {
        NewClientView view = new NewClientView();
        view.getSubmitButton().addActionListener(e->{
            Client client = new Client(Integer.parseInt(view.getIdField().getText()),view.getFirstNameField().getText(),view.getLastNameField().getText());
            clientModel.addClient(client);
            view.frame.dispose();
        });
    }

    private void findClientID(int i) {
        clientModel.getClientID(i);
    }

    private void refreshTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) view.getClientTable().getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("ID");
        model.addColumn("Imię");
        model.addColumn("Nazwisko");
        ResultSet rs = clientModel.getAllClients();
        while(rs.next())
        {
            model.addRow(new Object[]{rs.getInt("ID"), rs.getString("FirstName"),rs.getString("LastName")});
        }
    }
}
