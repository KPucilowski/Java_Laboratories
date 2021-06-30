package views;

import javax.swing.*;

public class PaymentView {
    private JPanel contentPane;
    private JButton refreshButton;
    private JTable chargeTable;
    private JTable paymentTable;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JButton addButton;

    public JButton getRefreshButton() {
        return refreshButton;
    }

    public JTable getChargeTable() {
        return chargeTable;
    }

    public JTable getPaymentTable() {
        return paymentTable;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }
    public JButton getDeleteButton(){
        return deleteButton;
    }
    private JButton editButton;
    private JButton returnButton;
    private JButton deleteButton;
    final JFrame frame;
    public PaymentView(){
        frame = new JFrame();
        returnButton.addActionListener(e->exit());
        scrollPane1.createHorizontalScrollBar();
        scrollPane2.createHorizontalScrollBar();
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    private void exit() {
        ChooseView chooseView = new ChooseView();
        frame.dispose();
    }
}
