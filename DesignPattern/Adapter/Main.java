package DesignPattern.Adapter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        FileIO f = new FileProperties();
        try {
            f.readFromFile("Adapter/file.txt");
            f.setValue("year", "2004");
            f.setValue("month", "12");
            f.writeToFile("Adapter/newfile.txt");
            //重复读入 相同键会覆盖 不同键仍然保留
            // f.readFromFile("Adapter/file.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

//Adapter
class FileProperties implements FileIO{

    //Adaptee
    Properties properties = new Properties();

    @Override
    public void readFromFile(String filename) throws IOException {
        properties.load(new FileInputStream(filename));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        properties.store(new FileOutputStream(filename), "written By JackLi");
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
