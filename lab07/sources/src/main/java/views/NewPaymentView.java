package views;

import javax.swing.*;

public class NewPaymentView {
    private JPanel contentPane;
    private JTextField prizeField;
    private JButton submitButton;
    private JTextField instalationIdField;
    private JTextField dateField;
    public final JFrame frame;
    public NewPaymentView(){
        frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public JTextField getPrizeField() {
        return prizeField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JTextField getInstalationIdField() {
        return instalationIdField;
    }

    public JTextField getDateField() {
        return dateField;
    }
}
