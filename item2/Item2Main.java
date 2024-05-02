package item2;

import item2.NyPizza.Size;
import item2.Pizza.Topping;

public class Item2Main {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(Size.SMALL)
                            .addTopping(Topping.SAUSAGE)
                            .addTopping(Topping.ONION)
                            .build();
        System.out.println(pizza);
    }
}
