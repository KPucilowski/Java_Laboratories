package app;

import javax.swing.*;

public class MainView {
    private JTextField serverPortField;
    private JButton sendButton;
    private JButton connectButton;
    private JTextField messageField;
    private JTextField clientPortField;
    private JTextField nameField;
    private JButton startServerButton;
    private JPanel contentPane;
    final JFrame frame;
    public MainView(){
        frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();

    }

    public JTextField getServerPortField() {
        return serverPortField;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public JButton getConnectButton() {
        return connectButton;
    }

    public JTextField getMessageField() {
        return messageField;
    }

    public JTextField getClientPortField() {
        return clientPortField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JButton getStartServerButton() {
        return startServerButton;
    }
}
