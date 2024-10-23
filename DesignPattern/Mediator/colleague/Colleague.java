package DesignPattern.Mediator.colleague;

import DesignPattern.Mediator.Mediator;

//Colleague
public interface Colleague {
    void setMediator(Mediator mediator);
    void setColleagueEnabled(boolean enabled);
} 