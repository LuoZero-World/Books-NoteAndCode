package DesignPattern.ChainOfRsponsibility;

import DesignPattern.ChainOfRsponsibility.handler.LimitSupport;
import DesignPattern.ChainOfRsponsibility.handler.NoSupport;
import DesignPattern.ChainOfRsponsibility.handler.SpecialSupport;
import DesignPattern.ChainOfRsponsibility.handler.Support;

public class Main {
    public static void main(String[] args) {
        Support s1 = new NoSupport("S1");
        Support s2 = new LimitSupport("S2_L", 65);
        Support s3 = new SpecialSupport("S3_S", 127);

        s1.setNext(s2).setNext(s3);
        for(int i = 10; i < 150; i += 3){
            s1.support(new Trouble(i));
        }
    }
}