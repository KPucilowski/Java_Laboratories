package Views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainView {
    JTextArea jTextArea = new JTextArea();
    JLabel contentLabel =  new JLabel();
    JFileChooser fileChooser = new JFileChooser();
    JPanel filePanel = new JPanel();
    private JPanel treePanel;
    private JPanel imagePanel;
    private JButton readButton;
    private JTextField informationField;
    private final JFrame frame;
    private JPanel contentPane;
    JLabel messageLabel = new JLabel();
    public MainView() {

        jTextArea.setEditable(false);
        JPanel jpanel= new JPanel();
        jpanel.add(jTextArea);
        frame = new JFrame("Aplikacja");
        filePanel.add(fileChooser);
        frame.add(filePanel, BorderLayout.WEST);
        frame.add(treePanel, BorderLayout.AFTER_LAST_LINE);
        jpanel.add(contentLabel);
        jpanel.add(messageLabel);
        frame.add(jpanel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
    public JLabel getContentLabel() {
        return contentLabel;
    }

    public JButton getReadButton() {
        return readButton;
    }
    public JPanel getImagePanel(){
        return imagePanel;
    }
    public JTextArea getjTextArea(){
        return jTextArea;
    }

    public JFileChooser getFileChooser(){return fileChooser;}

    public JPanel getFilePanel() {
        return filePanel;
    }
    public JTextField getInformationField(){
        return informationField;
    }
    public JLabel getMessageLabel(){
        return messageLabel;
    }
}
