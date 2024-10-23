package DesignPattern.Factory_Method.framework;

//创建者
public abstract class Factory {
    public final Product create(String owner){
        Product p = createProduct(owner);
        registerPrduct(p);
        return p;
    }
    
    protected abstract Product createProduct(String owner);
    protected abstract void registerPrduct(Product product);
}
