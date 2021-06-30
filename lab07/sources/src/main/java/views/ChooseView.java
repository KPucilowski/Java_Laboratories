package views;

import controller.ClientController;
import controller.InstalationController;
import controller.PaymentController;
import controller.ServiceController;
import daoImpl.*;
import tools.Connector;

import javax.swing.*;
import java.sql.SQLException;

public class ChooseView {


    private JPanel contentPane;
    private JButton showClientsButton;
    private JButton showInstalationsButton;
    private JButton showServiceButton;
    private JButton showPaymentButton;
    public final JFrame frame;
    public ChooseView(){
        frame = new JFrame();
        Connector connector = null;
        try {
            connector = new Connector();
            frame.setContentPane(contentPane);
            frame.pack();
            frame.setVisible(true);
            Connector finalConnector = connector;
            this.getShowClientsButton().addActionListener(e->{
                ClientDaoImpl clientModel = new ClientDaoImpl();
                ClientController clientController = new ClientController(clientModel, finalConnector);
                this.frame.dispose();
            });
            Connector finalConnector1 = connector;
            this.getShowInstalationsButton().addActionListener(e->{
                InstalationDaoImpl instalationModel = new InstalationDaoImpl();
                InstalationController instalationController = new InstalationController(instalationModel, finalConnector1);
                this.frame.dispose();
            });
            Connector finalConnector2 = connector;
            this.getShowServiceButton().addActionListener(e->{
                ServiceDaoImpl serviceModel = new ServiceDaoImpl();
                ServiceController serviceController = new ServiceController(serviceModel, finalConnector2);
                this.frame.dispose();
            });
            Connector finalConnector3 = connector;
            this.getShowPaymentButton().addActionListener(e->{
                ChargeDaoImpl chargeModel = new ChargeDaoImpl();
                PaymentDaoImpl paymentModel = new PaymentDaoImpl();
                PaymentController paymentController = new PaymentController(chargeModel,paymentModel, finalConnector3);
                this.frame.dispose();
            });
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public JButton getShowClientsButton() {
        return showClientsButton;
    }

    public JButton getShowInstalationsButton() {
        return showInstalationsButton;
    }

    public JButton getShowServiceButton() {
        return showServiceButton;
    }
    public JButton getShowPaymentButton() {
        return showPaymentButton;
    }
}
