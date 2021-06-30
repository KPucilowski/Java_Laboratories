package bilboards;

import javax.swing.*;

public class ClientGUI {
    private JTextField textField;
    private JTextField timeField;
    private JTextField clientPort;
    private JButton sendBoardButton;
    private JButton getManagerButton;
    private JTextField managerPort;
    private JPanel contentPane;
    private JButton removeBoardButton;
    private JTextField idTextField;
    final JFrame frame;

    public JButton getRemoveBoardButton() {
        return removeBoardButton;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public ClientGUI(){
        frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        }
    public JTextField getTextField() {
        return textField;
    }

    public JTextField getTimeField() {
        return timeField;
    }

    public JTextField getClientPort() {
        return clientPort;
    }

    public JButton getSendBoardButton() {
        return sendBoardButton;
    }

    public JButton getGetManagerButton() {
        return getManagerButton;
    }

    public JTextField getManagerPort() {
        return managerPort;
    }
}
