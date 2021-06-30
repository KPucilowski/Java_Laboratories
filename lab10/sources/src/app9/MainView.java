package app;

import javax.swing.*;

public class MainView {
    private JTextField serverPortField = new JTextField("5050");
    private JButton sendButton = new JButton("Wyślij");
    private JButton connectButton = new JButton("Połącz");
    private JTextField messageField = new JTextField("Wiadomość");
    private JTextField clientPortField = new JTextField("5050");
    private JTextField nameField = new JTextField("Imię");
    private JButton startServerButton = new JButton("wystartuj serwer");
    private JLabel label1 = new JLabel("Port Serwera");
    private JLabel label2 = new JLabel("Port Serwera");
    private JLabel label3 = new JLabel("Imię użytkownika");
    private JLabel label4 = new JLabel("Wiadomość");
    private JPanel contentPane = new JPanel();
    final JFrame frame;
    public MainView(){
        frame = new JFrame();
        contentPane.add(label1);
        contentPane.add(serverPortField);
        contentPane.add(startServerButton);
        contentPane.add(label2);
        contentPane.add(clientPortField);
        contentPane.add(label3);
        contentPane.add(nameField);
        contentPane.add(connectButton);
        contentPane.add(messageField);
        contentPane.add(sendButton);
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
