package Application;

import Views.MainView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class PngRead {

        public ImageIcon readPNG(String fileName, Map<String, byte[]> map,MainView mainView) throws IOException {
            byte[] bytes;
            if (map.containsKey(fileName) == false) {
                mainView.getInformationField().setText("Wczytano z pliku");
                Path path = Paths.get(fileName);

                bytes = Files.readAllBytes(path);

                map.put(fileName, bytes);
                ImageIcon imageIcon = new ImageIcon(bytes);
                Image image = imageIcon.getImage(); // transform it
                Image newimg = image.getScaledInstance(1000, 800,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                imageIcon = new ImageIcon(newimg);
                return imageIcon;
            } else {
                mainView.getInformationField().setText("Wczytano z mapy");
                bytes = map.get(fileName);
                ImageIcon imageIcon = new ImageIcon(bytes);
                Image image = imageIcon.getImage(); // transform it
                Image newimg = image.getScaledInstance(1000, 800,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                imageIcon = new ImageIcon(newimg);
                return imageIcon;
            }

        }

}
