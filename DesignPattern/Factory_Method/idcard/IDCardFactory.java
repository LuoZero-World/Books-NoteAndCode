package DesignPattern.Factory_Method.idcard;

import java.util.ArrayList;

import DesignPattern.Factory_Method.framework.Factory;
import DesignPattern.Factory_Method.framework.Product;

//具体创建者
public class IDCardFactory extends Factory{

    private ArrayList<Product> cards = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerPrduct(Product product) {
        cards.add(product);
    }

    public ArrayList<Product> getCards(){
        return cards;
    }
    
}
