package DesignPattern.Abstract_Factory.listfactory;

import java.util.Iterator;

import DesignPattern.Abstract_Factory.factory.Item;
import DesignPattern.Abstract_Factory.factory.Page;

public class ListPage extends Page{

    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>"+title+"</title></head>\n");
        sb.append("<body>\n");
        sb.append("<h1>"+title+"</h1>\n");
        sb.append("<ul>\n");

        Iterator<Item> iterator = content.iterator();
        while(iterator.hasNext()){
            Item item = iterator.next();
            sb.append(item.makeHTML());
        }

        sb.append("</ul>\n");
        sb.append("<hr><address>"+author+"</hr></address>");
        sb.append("</body></html>\n");
        return sb.toString();
    }
    
}
