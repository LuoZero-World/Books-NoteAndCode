package DesignPattern.Strategy.strategy;

import java.util.Random;

import DesignPattern.Strategy.Hand;

//ConcreteStrategy
public class ProbStrategy implements Strategy{

    private Random random;
    private int prevHandV = 0, currentHandV = 0;
    private int[][] history = {
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
    };

    public ProbStrategy(int seed){
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandV));
        int handV = 0, betP = 0;
        for(int i = 0; i < 3; i++){
            betP += history[currentHandV][i];
            if(bet <= betP){
                handV = i;
                break;
            }
        }
        prevHandV = currentHandV;
        currentHandV = handV;
        return Hand.values()[handV];
    }

    @Override
    public void study(boolean win) {
        if(win){
            history[prevHandV][currentHandV]++;
        } else{
            history[prevHandV][(currentHandV+1)%3]++;
            history[prevHandV][(currentHandV+2)%3]++;
        }
    }

    private int getSum(int hv){
        int sum = 0;
        for(int i = 0; i < 3; i++) sum += history[hv][i];
        return sum;
    }
    
}
