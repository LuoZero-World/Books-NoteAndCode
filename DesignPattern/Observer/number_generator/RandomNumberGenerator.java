package DesignPattern.Observer.number_generator;

import java.util.Random;

//ConcreteSubject
public class RandomNumberGenerator extends NumberGenerator{

    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void execute() {
        for(int i = 0; i < 5; i++){
            number = random.nextInt(50);
            notifyObservers();
        }
    }
    
}
