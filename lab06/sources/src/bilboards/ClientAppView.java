package bilboards;

import javax.swing.*;

public class ClientAppView {
    private JTextField clientTextField;
    private JTextField serverTextField;
    private JButton registerButton;
    private JButton connectButton;
    private JButton startButton;
    private JButton exitButton;
    private JTextField advertTextField;
    private JTextField durationTextField;
    private JPanel contentPane;
    final JFrame frame;

    public ClientAppView() {
        frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public JTextField getClientTextField() {
        return clientTextField;
    }

    public JTextField getServerTextField() {
        return serverTextField;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JButton getConnectButton() {
        return connectButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JTextField getAdvertTextField() {
        return advertTextField;
    }

    public JTextField getDurationTextField() {
        return durationTextField;
    }



}
