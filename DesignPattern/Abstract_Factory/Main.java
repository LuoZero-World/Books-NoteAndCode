package DesignPattern.Abstract_Factory;

import DesignPattern.Abstract_Factory.factory.Factory;
import DesignPattern.Abstract_Factory.factory.Link;
import DesignPattern.Abstract_Factory.factory.Page;
import DesignPattern.Abstract_Factory.factory.Tray;

public class Main {
    public static void main(String[] args) {
        Factory factory = Factory.getFactory("Abstract_Factory.listfactory.ListFactory");
        Link pp = factory.createLink("pp newspaper", "http://www.pp.com.cn");
        Link gmy = factory.createLink("gmy newspaper", "http://www.gmy.com.cn");

        Tray trayNews = factory.createTray("新闻报纸");
        trayNews.add(pp);
        trayNews.add(gmy);

        Page page = factory.createPage("ListPage", "JackLi");
        page.add(trayNews);
        page.output();
    }
}
