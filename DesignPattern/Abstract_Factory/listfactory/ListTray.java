package DesignPattern.Abstract_Factory.listfactory;

import java.util.Iterator;

import DesignPattern.Abstract_Factory.factory.Item;
import DesignPattern.Abstract_Factory.factory.Tray;

public class ListTray extends Tray{

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<li>\n");
        sb.append(caption+"\n");
        sb.append("<ul>\n");

        Iterator<Item> iterator = tray.iterator();
        while(iterator.hasNext()){
            Item item = iterator.next();
            sb.append(item.makeHTML());
        }

        sb.append("<ul>\n");
        sb.append("<li>\n");

        return sb.toString();
    }
    
}
