package DesignPattern.Factory_Method;

import DesignPattern.Factory_Method.framework.Factory;
import DesignPattern.Factory_Method.framework.Product;
import DesignPattern.Factory_Method.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("JackLi");
        Product card2 = factory.create("ppap");

        card1.use();
        card2.use();
    }
}