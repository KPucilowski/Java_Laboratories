package views;

import objects.Service;

import javax.swing.*;

public class NewServiceView {
    private JButton submitButton;
    private JTextField IdField;
    private JTextField prizeField;
    private JTextField serviceTypeField;
    private JPanel contentPane;
    public final JFrame frame;
    public Service service;
    public NewServiceView(){
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
        return IdField;
    }

    public JTextField getPrizeField() {
        return prizeField;
    }

    public JTextField getServiceTypeField() {
        return serviceTypeField;
    }

}
