package View;

import App.MyClassLoader;
import processing.Status;
import processing.StatusListener;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainView {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JPanel contentPane;
    private JProgressBar progressBar;
    private JButton loadButton;
    private JComboBox comboBox1;
    final JFrame frame;
    public MainView(){
        progressBar.setStringPainted(true);
        frame = new JFrame("App");
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }
    public JProgressBar getProgressBar(){
        return progressBar;
    }

    public void init(){
        loadButton.addActionListener(e-> {
            try {
                invokeMethod();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NoSuchMethodException noSuchMethodException) {
                noSuchMethodException.printStackTrace();
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            } catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            } catch (InstantiationException instantiationException) {
                instantiationException.printStackTrace();
            }
        });
    }

    private void invokeMethod() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String className = (String) comboBox1.getSelectedItem();
        StringBuilder sb = new StringBuilder(className);
        int length = className.length();
        char actual,prev;
        String name;
        int i;
        for(i = 1;i<length;i++){
            actual = sb.charAt(i);
            prev = sb.charAt(i-1);
            if(actual=='>'&&prev=='-'){
               break;
            }
        }


        name = className.substring(0,i-1);
        MyClassLoader loader = new MyClassLoader();
        Class<?> c = loader.loadClassData("processing." + name);
        Object o1 = c.getConstructor().newInstance();
        String paramText = textArea1.getText();
        Method descriptSetText = c.getMethod("setText",paramText.getClass());
        Method descriptSL = c.getMethod("getSl",null);
        //
        Method descriptGetResult = c.getMethod("getResult",null);
        descriptSetText.invoke(o1,paramText);

        StatusListener statusListener = (StatusListener) descriptSL.invoke(o1);
        Method descriptTask = c.getMethod("submitTask",new Class[] {String.class, StatusListener.class});


        if((boolean) descriptTask.invoke(o1,paramText,statusListener)==true){
            progressBar.setValue(100);
        }
        textArea2.setText((String) descriptGetResult.invoke(o1));
    }
}
