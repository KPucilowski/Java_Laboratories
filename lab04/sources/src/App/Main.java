package App;

import View.MainView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        Scanner scan = new Scanner(System.in);
        MainView view = new MainView();

        MyClassLoader loader = new MyClassLoader();
        Class<?> c = loader.loadClassData("processing.BigLetters");
        Object o1 = c.getConstructor().newInstance();
        Class<?> d = loader.loadClassData("processing.Counter");
        Class<?> s = loader.loadClassData("processing.Infantilization");
        Object o2 = d.getConstructor().newInstance();
        Object o3 = s.getConstructor().newInstance();
        Method descript1 = c.getMethod("getInfo",null);
        Method descript2 = d.getMethod("getInfo",null);
        Method descript3 = s.getMethod("getInfo",null);
        Method descriptName1 = c.getMethod("getName",null);
        Method descriptName2 = d.getMethod("getName",null);
        Method descriptName3 = s.getMethod("getName",null);

        String class1 = descriptName1.invoke(o1)+"->"+descript1.invoke(o1);
        String class2 = descriptName2.invoke(o2)+"->"+descript2.invoke(o2);
        String class3 = descriptName3.invoke(o3)+"->"+descript3.invoke(o3);
        view.getComboBox1().addItem(class1);
        view.getComboBox1().addItem(class2);
        view.getComboBox1().addItem(class3);
        view.init();


    }
}
