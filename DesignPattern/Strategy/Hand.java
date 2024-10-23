package DesignPattern.Strategy;

public enum Hand {
    ROCK,
    PAPER,
    SCISSORS;

    public int compaerWith(Hand h){
        int me = this.ordinal(), you = h.ordinal();
        if(me == you) return 0;
        else if((me+1)%3 == you) return -1;
        else return 1;
    }
}
