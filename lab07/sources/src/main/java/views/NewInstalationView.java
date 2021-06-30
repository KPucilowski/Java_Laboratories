package views;

import javax.swing.*;

public class NewInstalationView {
    private JButton submitButton;
    private JTextField idField;
    private JTextField adressField;
    private JTextField routerNumberField;
    private JTextField serviceField;
    private JTextField clientIDField;
    private JPanel contentPane;
    public final JFrame frame;
    public NewInstalationView(){
        frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public JButton getSubmitButton() {
        return submitButton;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getAdressField() {
        return adressField;
    }

    public JTextField getRouterNumberField() {
        return routerNumberField;
    }

    public JTextField getServiceField() {
        return serviceField;
    }

    public JTextField getClientIDField() {
        return clientIDField;
    }
}
