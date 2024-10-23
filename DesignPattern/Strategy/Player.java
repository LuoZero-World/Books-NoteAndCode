package DesignPattern.Strategy;

import DesignPattern.Strategy.strategy.Strategy;

//Context
public class Player {
    private String name;
    private Strategy strategy;
    private int winCount = 0, loseCount = 0, gameCount = 0;

    public Player(String name, Strategy strategy){
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand(){
        return strategy.nextHand();
    }

    public void win(){
        strategy.study(true);
        winCount++;
        gameCount++;
    }

    public void lose(){
        strategy.study(false);
        loseCount++;
        gameCount++;
    }

    public void even(){
        gameCount++;
    }

    public void showMe(){
        System.out.println(name+": ");
        System.out.println(winCount+"-"+loseCount+"-"+gameCount);
    }
}
