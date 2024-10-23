package DesignPattern.ChainOfRsponsibility.handler;

import DesignPattern.ChainOfRsponsibility.Trouble;

public class SpecialSupport extends Support{

    private int sid;

    public SpecialSupport(String name, int sid) {
        super(name);
        this.sid = sid;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getTid() == sid) return true;
        return false;
    }
    
}
