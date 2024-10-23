package DesignPattern.Abstract_Factory.factory;

public abstract class Item implements HTMLable{
    protected String caption;
    public Item(String caption){
        this.caption = caption;
    }
}
