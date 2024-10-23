package DesignPattern.Abstract_Factory.factory;

//抽象零件
public abstract class Link extends Item{

    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
    
}
