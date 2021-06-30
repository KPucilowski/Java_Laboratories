package app;

import javax.swing.*;

public class AppView {
    private JTextField sizeField;
    private JTextField minField;
    private JTextField maxField;
    private JButton loadButton;
    private JButton kmeansButton;
    private JPanel contentPane;
    private JTextField minYField;
    private JTextField maxYField;
    final JFrame frame;

    public AppView() {
        frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JTextField getSizeField() {
        return sizeField;
    }

    public JTextField getMinField() {
        return minField;
    }

    public JTextField getMaxField() {
        return maxField;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JButton getKmeansButton() {
        return kmeansButton;
    }

    public JTextField getMinYField() {
        return minYField;
    }

    public JTextField getMaxYField() {
        return maxYField;
    }
}
