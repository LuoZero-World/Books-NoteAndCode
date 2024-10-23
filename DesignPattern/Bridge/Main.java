package DesignPattern.Bridge;

import DesignPattern.Bridge.func_hierarchy.CountDisplay;
import DesignPattern.Bridge.func_hierarchy.Display;
import DesignPattern.Bridge.func_hierarchy.IncreaseDisplay;
import DesignPattern.Bridge.impl_hierarchy.CharDisplayImpl;
import DesignPattern.Bridge.impl_hierarchy.StringDisplayImpl;

public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello"));
        CountDisplay d2 = new CountDisplay(new StringDisplayImpl("ppap"));
        
        d1.display();
        d2.multiDisplay(5);

        IncreaseDisplay d3 = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'), 1);
        d3.increaseDisplay(5);
    }
}
