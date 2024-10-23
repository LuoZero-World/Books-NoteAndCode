package DesignPattern.Abstract_Factory.listfactory;

import DesignPattern.Abstract_Factory.factory.Factory;
import DesignPattern.Abstract_Factory.factory.Link;
import DesignPattern.Abstract_Factory.factory.Page;
import DesignPattern.Abstract_Factory.factory.Tray;

public class ListFactory extends Factory{

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
    
}
