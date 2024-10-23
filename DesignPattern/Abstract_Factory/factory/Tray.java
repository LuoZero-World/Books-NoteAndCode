package DesignPattern.Abstract_Factory.factory;

import java.util.ArrayList;

//抽象零件
public abstract class Tray extends Item{

    protected ArrayList<Item> tray = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item){
        tray.add(item);
    }
    
}
