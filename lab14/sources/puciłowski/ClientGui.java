package puciłowski;

import javax.swing.*;

public class ClientGui {
    private JButton addButton;
    private JButton deleteButton;
    private JTextField nameField;
    private JTextField priorityField;
    private JPanel contentPane;

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getPriorityField() {
        return priorityField;
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    final JFrame frame;
    public ClientGui(){
        frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
