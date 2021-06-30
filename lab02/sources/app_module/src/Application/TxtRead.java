package Application;

import Views.MainView;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class TxtRead {

    public String readTxt(String fileName, Map<String, byte[]> map, MainView mainView) throws IOException {
        ImageIcon imageIcon = new ImageIcon();
        JTextArea jTextArea = new JTextArea();
        byte[] bytes;
        if(map.containsKey(fileName) == false){
            mainView.getInformationField().setText("Wczytano z pliku");
        Path path = Paths.get(fileName);

        bytes=Files.readAllBytes(path);

        String k = new String(bytes, StandardCharsets.UTF_8);
        map.put(fileName,bytes);

        return k;
        }
        else{
            mainView.getInformationField().setText("Wczytano z mapy");
            bytes=map.get(fileName);
            String k = new String(bytes, StandardCharsets.UTF_8);
            jTextArea.setText(k);
        return k;

        }
    }
}
