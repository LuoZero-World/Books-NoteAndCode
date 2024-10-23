package DesignPattern.Strategy;

import DesignPattern.Strategy.strategy.ProbStrategy;
import DesignPattern.Strategy.strategy.WinningStrategy;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Jack", new WinningStrategy(1500));
        Player p2 = new Player("Tom", new ProbStrategy(200));

        for(int i = 0; i < 10000; i++){
            Hand h1 = p1.nextHand();
            Hand h2 = p2.nextHand();
            if(h1.compaerWith(h2) > 0){
                p1.win();
                p2.lose();
            } else if(h1.compaerWith(h2) < 0){
                p1.lose();
                p2.win();
            } else{
                p1.even();
                p2.even();
            }
        }
        p1.showMe();
        p2.showMe();
    }
}
