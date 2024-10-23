package DesignPattern.ChainOfRsponsibility;

//Client
public class Trouble {
    private int tid;

    public Trouble(int tid){
        this.tid = tid;
    }

    public int getTid(){
        return tid;
    }

    @Override
    public String toString(){
        return "[Trouble "+tid+"]";
    }
}
