package views;

import javax.swing.*;

public class ClientView {
    private JButton addClientButton;
    private JButton editClientButton;
    private JTable clientTable;
    private JScrollPane scrollPane;
    private JPanel contentPane;
    private JButton refreshButton;
    private JButton deleteClientButton;
    private JButton returnButton;
    final JFrame frame;
    public ClientView(){
        frame = new JFrame();
        returnButton.addActionListener(e->exit());
        scrollPane.createHorizontalScrollBar();
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    private void exit() {
        ChooseView chooseView = new ChooseView();
        frame.dispose();
    }

    public JButton getDeleteClientButton() {
        return deleteClientButton;
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }

    public JButton getAddClientButton() {
        return addClientButton;
    }

    public JButton getEditClientButton() {
        return editClientButton;
    }

    public JTable getClientTable() {
        return clientTable;
    }
}
