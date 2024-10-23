package DesignPattern.Observer;

import DesignPattern.Observer.number_generator.IncrementalNumberGenerator;
import DesignPattern.Observer.number_generator.NumberGenerator;
import DesignPattern.Observer.observer.DigitObserver;
import DesignPattern.Observer.observer.GraphObserver;
import DesignPattern.Observer.observer.Observer;

public class Main {
    public static void main(String[] args) {
        NumberGenerator g = new IncrementalNumberGenerator(10, 50, 5);
        Observer ob1 = new DigitObserver();
        Observer ob2 = new GraphObserver();

        g.addObserver(ob1);
        g.addObserver(ob2);

        g.execute();
    }
}
