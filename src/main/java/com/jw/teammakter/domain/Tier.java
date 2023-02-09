package com.jw.teammakter.domain;

import java.util.stream.Stream;

public enum Tier {

    IRON("iron", 0),
    BRONZE("bronze", 10),
    SILVER("silver", 20),
    GOLD1("gold1", 25),
    GOLD2("gold2", 27),
    GOLD3("gold3", 29),
    GOLD4("gold4", 31),
    PLATINUM1("platinum1", 38),
    PLATINUM2("platinum2", 45),
    PLATINUM3("platinum3", 53),
    PLATINUM4("platinum4", 60),
    DIAMOND1("diamond1", 70),
    DIAMOND2("diamond2", 80),
    DIAMOND3("diamond3", 90),
    DIAMOND4("diamond4", 100),
    ;


    private String tier;
    private int point;

    Tier(String tier, int point){
        this.tier = tier;
        this.point = point;
    }
    public String getTier(){
        return this.tier;
    }
    public int getPoint(){
        return this.point;
    }
    public static Stream<Tier> stream() {
        return Stream.of(Tier.values());
    }
}
