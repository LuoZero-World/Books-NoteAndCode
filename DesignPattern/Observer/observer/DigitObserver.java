package DesignPattern.Observer.observer;

import DesignPattern.Observer.number_generator.NumberGenerator;

//ConcreteObserver
public class DigitObserver implements Observer{
    
    @Override
    public void update(NumberGenerator generator){
        System.out.println("DObserver"+generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
