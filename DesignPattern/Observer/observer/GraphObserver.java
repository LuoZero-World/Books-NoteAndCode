package DesignPattern.Observer.observer;

import DesignPattern.Observer.number_generator.NumberGenerator;

//ConcreteObserver
public class GraphObserver implements Observer{

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("GObserver");
        int count = generator.getNumber();
        for(int i = 0; i < count; i++) System.out.print("*");
        System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
