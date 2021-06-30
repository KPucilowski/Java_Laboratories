package bilboards;

import javax.swing.*;

public class BillboardGUI {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JPanel contentPane;
    private JButton bindButton;
    private JTextField portField;
    final JFrame frame;
    public BillboardGUI(){
     frame = new JFrame();
     frame.setContentPane(contentPane);
     frame.setVisible(true);
     frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     frame.pack();
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public JTextArea getTextArea2() {
        return textArea2;
    }

    public JTextArea getTextArea3() {
        return textArea3;
    }

    public JTextArea getTextArea4() {
        return textArea4;
    }

    public JTextArea getTextArea5() {
        return textArea5;
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public JButton getBindButton() {
        return bindButton;
    }

    public JTextField getPortField() {
        return portField;
    }
}
