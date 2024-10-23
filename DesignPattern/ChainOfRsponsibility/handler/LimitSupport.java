package DesignPattern.ChainOfRsponsibility.handler;

import DesignPattern.ChainOfRsponsibility.Trouble;

public class LimitSupport extends Support{

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getTid() < limit) return true;
        return false;
    }
    
}
