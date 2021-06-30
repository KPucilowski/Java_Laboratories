package views;

import javax.swing.*;

public class ServiceView {
    private JButton addServiceButton;
    private JButton editServiceButton;
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTable serviceTable;
    private JButton refreshButton;
    private JButton deleteInstalatoinButton;
    private JButton returnButton;
    final JFrame frame;

    public ServiceView(){
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
    public JButton getDeleteInstalatoinButton() {
        return deleteInstalatoinButton;}
    public JButton getRefreshButton() {
        return refreshButton;
    }

    public JButton getAddServiceButton() {
        return addServiceButton;
    }

    public JButton getEditServiceButton() {
        return editServiceButton;
    }

    public JTable getServiceTable() {
        return serviceTable;
    }
}
