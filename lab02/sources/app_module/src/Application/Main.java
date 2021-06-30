package Application;

import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;

public class Main {


    public static void main(String[] args) throws IOException {
        Map<String, byte[]> map;
        map = new WeakHashMap<String, byte[]>();

        MainController mainController = new MainController();
        mainController.initController();

    }}
