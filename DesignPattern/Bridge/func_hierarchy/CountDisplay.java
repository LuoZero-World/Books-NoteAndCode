package DesignPattern.Bridge.func_hierarchy;

import DesignPattern.Bridge.impl_hierarchy.DisplayImpl;

//RefinedAbstraction
public class CountDisplay extends Display{

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times){
        open();
        for(int i = 0; i < times; i++) print();
        close();
    }
    
}
