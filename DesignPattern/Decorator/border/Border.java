package DesignPattern.Decorator.border;

import DesignPattern.Decorator.display.Display;

//Decorator
public abstract class Border extends Display{
    protected Display display;      //被装饰者
    protected Border(Display display){
        this.display = display;
    }
}
