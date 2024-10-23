package DesignPattern.Factory_Method.idcard;

import DesignPattern.Factory_Method.framework.Product;

//具体产品
public class IDCard extends Product{

    private String owner;

    IDCard(String owner){
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("use "+owner+" success!");
    }

    public String getOwner(){
        return owner;
    }
    
}
