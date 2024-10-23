package DesignPattern.Abstract_Factory.factory;

//抽象工厂
public abstract class Factory {
    public static Factory getFactory(String classname){
        Factory factory = null;
        try {
            factory = (Factory)Class.forName(classname).getConstructor().newInstance();
        } catch(ClassNotFoundException e){
            System.err.println(classname+"Not Fount!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }
    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);

}
