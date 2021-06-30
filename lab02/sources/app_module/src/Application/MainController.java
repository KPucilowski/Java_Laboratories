package Application;

import Views.MainView;
import javax.swing.*;
import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;

public class MainController {
    MainView mainView = new MainView();
    PngRead pngRead = new PngRead();
    TxtRead txtRead = new TxtRead();
    public void initController(){
        mainView.getMessageLabel().setVisible(false);
        WeakHashMap<String,byte[]> map = new WeakHashMap<>();

        mainView.getReadButton().addActionListener(e-> displayFile(String.valueOf(mainView.getFileChooser().getSelectedFile()),map));
    }


    private void presentImage(ImageIcon imageIcon) {
        mainView.getMessageLabel().setVisible(false);
        mainView.getjTextArea().setVisible(false);
        mainView.getContentLabel().setVisible(true);
        mainView.getContentLabel().setIcon(imageIcon);
        //mainView.getContentLabel().setText();
    }

    private void presentText(String text){
        mainView.getMessageLabel().setVisible(false);
        mainView.getContentLabel().setVisible(false);
        mainView.getjTextArea().setVisible(true);
        mainView.getjTextArea().setText(text);

    }
    public void displayFile(String patch, Map<String, byte[]> map){
        {
            if(patch==null){
            mainView.getInformationField().setText("Nie wybrano pliku");
            }else{
            try {
                String extension = "";

                int i = patch.lastIndexOf('.');
                if (i >= 0) {
                    extension = patch.substring(i+1);
                }
                if(extension.equals("txt")){
                    presentText(txtRead.readTxt(patch,map, mainView));}
                else{
                if(extension.equals("png")) {
                    presentImage(pngRead.readPNG(patch, map, mainView));
                }
                else{
                    mainView.getContentLabel().setVisible(false);
                    mainView.getjTextArea().setVisible(false);
                    mainView.getMessageLabel().setText("Nie potrafię wyświelić tego na ekranie");
                    mainView.getMessageLabel().setVisible(true);
                }}
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }}
    }


}
