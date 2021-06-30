package View;

import javax.swing.*;

public class AplikacjaView {
    private final JFrame frame;
    private JButton generateButton;
    private JButton checkButton;
    private JTextField directoryField;
    private JLabel directoryLabel;
    private JButton chooseButton;
    private JPanel contentPane;

    public AplikacjaView(){
        frame = new JFrame("Aplikacja");
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JButton getCheckButton() {
        return checkButton;
    }

    public JButton getChooseButton() {
        return chooseButton;
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public JTextField getDirectoryField() {
        return directoryField;
    }
}
