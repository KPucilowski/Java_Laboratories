package Views;

import javax.swing.*;
import javax.swing.text.View;

public class LanguageView {
    private JComboBox selectLanguageBox;
    private JButton selectLanguageButton;
    private JPanel contentPane;
    private final JFrame frame;
    private LanguageView view;
    public LanguageView(){
        frame = new JFrame("language");
        selectLanguageButton.addActionListener(e->chooseLanguage(String.valueOf(selectLanguageBox.getSelectedItem())));
        frame.setContentPane(contentPane);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JButton getSelectLanguageButton() {
        return selectLanguageButton;
    }

    public JComboBox getSelectLanguageBox() {
        return selectLanguageBox;
    }



    private void chooseLanguage(String language) {
        //language=view.getSelectLanguageBox().getSelectedItem().toString();
        MainView mainView = new MainView(language);
        frame.setVisible(false);
    }
}
