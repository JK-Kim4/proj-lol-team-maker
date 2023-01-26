package com.jw.teammakter.domain;

import java.util.stream.Stream;

public enum Position {

    TOP("top", 80), JUNGLE("jungle", 100),
    APCARRY("middle", 70), ADCARRY("adcarry", 60),
    SUPPORTER("supporter", 60), ALLROUNDER("allrounder", 85);

    private String position;
    private int point;

    Position(String position, int point) {
        this.position = position;
        this.point = point;
    }

    public String getPosition(){
        return this.position;
    }

    public int getPoint(){
        return this.point;
    }

    public static Stream<Position> stream() {
        return Stream.of(Position.values());
    }
}
