package com.jw.teammaker.domain.enumtype;

public enum Tier {

    IRON(0),
    BRONZE(10),
    SILVER(25),
    GOLD(40),
    PLATINUM(55),
    DIAMOND(70),
    MASTER(80),
    GRANDMASTER(95),
    CHALLENGER(100),
    SEMIPRO(150),
    PRO(300);

    private int point;

    Tier(int point){
        this.point = point;
    }


    public int getPoint(){
        return this.point;
    }

}
