package bilboards;

import javax.swing.*;

public class ManagerGUI {
    private JTextField textField;
    private JButton acceptButton;
    private JPanel contentPane;
    private JTextField timeField;
    private JButton checkButton;
    private JTextField availablityTextField;
    private JTextField idField;
    private JButton deleteButton;
    private JTextField getIDField;
    final JFrame frame;

    public JTextField getPortField() {
        return textField;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton getAcceptButton() {
        return acceptButton;
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public JTextField getTimeField() {
        return timeField;
    }

    public JButton getCheckButton() {
        return checkButton;
    }

    public JTextField getAvailablityTextField() {
        return availablityTextField;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JTextField getGetIDField() {
        return getIDField;
    }

    public JButton getBindButton() {
        return acceptButton;
    }

    public ManagerGUI(){
        deleteButton.setVisible(false);
        acceptButton.setVisible(false);
        frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
    }

}
