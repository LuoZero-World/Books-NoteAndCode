package DesignPattern.Observer.number_generator;

import java.util.ArrayList;
import java.util.Iterator;

import DesignPattern.Observer.observer.Observer;

//Subject
public abstract class NumberGenerator {
    protected int number;
    ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void deleteObserver(Observer observer){
        observers.remove(observer);
    }
    public void notifyObservers(){
        Iterator<Observer> iterator = observers.iterator();
        while(iterator.hasNext()){
            iterator.next().update(this);
        }
    }
    public int getNumber(){
        return number;
    }

    public abstract void execute();
}
