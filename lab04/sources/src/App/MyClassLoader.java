package App;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class MyClassLoader extends ClassLoader {

    public Class loadClassData(String className) throws IOException {
        String classNamePath;
        StringBuilder sb = new StringBuilder(className);
        char actual;
        boolean stop=false;
        int i =0;
        while(stop==false) {
            actual = sb.charAt(i);
            i++;
            if(actual == '.'){


                stop=true;

            }}
            StringBuffer text = new StringBuffer(className);
            text.replace( 0 ,i ,"");
            classNamePath = String.valueOf(text);
        classNamePath = classNamePath + ".class";
        String path = "C:\\Users\\Krzysztof\\Documents\\kontener_klas\\"+classNamePath;

        Path pathToClass = Paths.get(path);
        byte[] allBytes = Files.readAllBytes(pathToClass);
        return defineClass(className,allBytes,0, allBytes.length);
    }

}