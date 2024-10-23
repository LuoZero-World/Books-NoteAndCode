package DesignPattern.Bridge.func_hierarchy;

import DesignPattern.Bridge.impl_hierarchy.DisplayImpl;

//Abstraction
public class Display{
    private DisplayImpl impl;       //Bridge !!!

    public Display(DisplayImpl impl){
        this.impl = impl;
    }

    public void open(){
        impl.rawOpen();
    }

    public void print(){
        impl.rawPrint();
    }

    public void close(){
        impl.rawClose();
    }

    public final void display(){
        open();
        print();
        close();
    }
}