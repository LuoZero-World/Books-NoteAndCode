package DesignPattern.Observer.number_generator;

//ConcreteSubject
public class IncrementalNumberGenerator extends NumberGenerator{

    int original, end, step;

    public IncrementalNumberGenerator(int original, int end, int step){
        this.original = original;
        this.end = end;
        this.step = step;
    }

    @Override
    public void execute() {
        for(int i = original; i <= end; i += step){
            number = i;
            notifyObservers();
        }
    }
    
}
