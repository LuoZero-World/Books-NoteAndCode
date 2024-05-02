package item2;

import item2.NyPizza.Size;
import item2.Pizza.Topping;

/*
 * Item2: Consider a builder when faced with many constuctor parameters
 * 原书提及的建造者模式，每个内部Builder都需要对每个字段建立相应方法，代码冗长
 * 可以将【构建机制】独立出来，通过 泛型+反射 进行构建以广泛适应相似需求
 * 详见 https://github.com/clxering/Effective-Java-3rd-edition-Chinese-English-bilingual
 */
public class Item2Main {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(Size.SMALL)
                            .addTopping(Topping.SAUSAGE)
                            .addTopping(Topping.ONION)
                            .build();
        System.out.println(pizza.getSize());
    }
}
