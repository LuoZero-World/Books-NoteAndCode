package DesignPattern.ChainOfRsponsibility.handler;

import DesignPattern.ChainOfRsponsibility.Trouble;

//Handler
public abstract class Support {
    private String name;
    private Support next;

    public Support(String name){
        this.name = name;
    }

    public Support setNext(Support support){
        next = support;
        return next;
    }

    public final void support(Trouble t){
        if(resolve(t)){
            done(t);
        } else if(next != null){
            next.support(t);
        } else{
            fail(t);
        }
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble){
        System.out.println(trouble+" is resolved by "+this);
    }

    protected void fail(Trouble trouble){
        System.out.println(trouble+" cannot resolved");
    }

    @Override
    public String toString() {
        return "["+name+"]";
    }
}
