package DesignPattern.Observer.observer;

import DesignPattern.Observer.number_generator.NumberGenerator;

//Observer
public interface Observer {
    public abstract void update(NumberGenerator generator);
}
