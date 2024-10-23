package DesignPattern.Abstract_Factory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;

//抽象产品
public abstract class Page implements HTMLable{
    protected String title;
    protected String author;
    protected ArrayList<Item> content = new ArrayList<>();

    public Page(String title, String author){
        this.title = title;
        this.author = author;
    }

    public void add(Item item){
        content.add(item);
    }

    public void output(){
        try {
            String filename = "Abstract_Factory/"+title+".html";
            Writer writer = new FileWriter(filename, Charset.forName("UTF-8"));
            writer.write(this.makeHTML());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
