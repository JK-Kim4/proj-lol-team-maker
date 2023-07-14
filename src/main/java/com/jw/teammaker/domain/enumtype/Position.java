package com.jw.teammaker.domain.enumtype;

public enum Position {

    TOP(7),
    JNG(8),
    MID(8),
    AD(10),
    SUP(9),
    ALL( 8);

    private int point;

    Position(int point){
        this.point = point;
    }

    public int getPoint(){
        return this.point;
    }

}
