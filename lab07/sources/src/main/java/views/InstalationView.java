package views;

import javax.swing.*;

public class InstalationView {
    private JButton addInstalationButton;
    private JButton editInstalationButton;
    private JTable instalationTable;
    private JScrollPane scrollPane;
    private JPanel contentPane;
    private JButton refreshButton;
    private JButton deleteInstalationButton;
    private JButton returnButton;
    final JFrame frame;
public InstalationView(){
    frame = new JFrame();
    returnButton.addActionListener(e->exit());
    frame.setSize(800,500);
    frame.setResizable(false);
    scrollPane.createHorizontalScrollBar();
    frame.setContentPane(contentPane);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}

    private void exit() {
    ChooseView chooseView = new ChooseView();
    frame.dispose();
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }

    public JButton getDeleteInstalationButton() {
        return deleteInstalationButton;
    }

    public JButton getAddInstalationButton() {
        return addInstalationButton;
    }

    public JButton getEditInstalationButton() {
        return editInstalationButton;
    }

    public JTable getInstalationTable() {
        return instalationTable;
    }
}
