package DesignPattern.Strategy.strategy;

import DesignPattern.Strategy.Hand;

public interface Strategy {
    public abstract Hand nextHand();
    public abstract void study(boolean win);
}
