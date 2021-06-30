package views;

import javax.swing.*;
import java.awt.*;

public class NewClientView {
    private JButton submitButton;
    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JPanel contentPane;
    public final JFrame frame;
    public NewClientView(){
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

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }
}
