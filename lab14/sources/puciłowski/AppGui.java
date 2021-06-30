package puciłowski;

import javax.swing.*;

public class AppGui {
    private JPanel contentPane;
    private JLabel titleLabel;
    private JTable tableA;
    private JTable tableB;
    private JTable tableC;
    private JTable tableD;
    private JButton generateButton;
    private JComboBox chooseBox;
    private JTextField idField;
    final JFrame frame;
    public AppGui(){
        frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTable getTableA() {
        return tableA;
    }

    public JTable getTableB() {
        return tableB;
    }

    public JTable getTableC() {
        return tableC;
    }

    public JTable getTableD() {
        return tableD;
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public JComboBox getChooseBox() {
        return chooseBox;
    }
}
