package com.jw.teammaker.domain.enumtype;

public enum TierNumber {

    ONE(10),
    TWO(20),
    THREE(30),
    FOUR(40),
    FIVE(50),
    MASTER(70),
    GRANDMASTER(100);

    private int point;

    TierNumber( int point){
        this.point = point;
    }

    public int getPoint(){
        return this.point;
    }

}
