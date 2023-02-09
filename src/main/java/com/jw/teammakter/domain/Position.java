package com.jw.teammakter.domain;

import com.jw.teammakter.common.util.CommonUtil;

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

    /*Position.ALLROUNDER 에게 임의 포지션 할당*/
    public static String alignRandomPositionForAllRounder(){
        int validator = CommonUtil.randomIntGenerateOnRange(1,5);
        switch (validator){
            case 1:
                return Position.TOP.name();
            case 2:
                return Position.JUNGLE.name();
            case 3:
                return Position.APCARRY.name();
            case 4:
                return Position.ADCARRY.name();
            default:
                return Position.SUPPORTER.name();
        }
    }
}
