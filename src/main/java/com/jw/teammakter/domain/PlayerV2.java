package com.jw.teammakter.domain;

public class PlayerV2 {

    public PlayerV2(){};

    public PlayerV2(String name, String positionMain, String positionSub, String tier){
        this.name = name;
        this.positionMain = Position.valueOf(positionMain);
        this.positionSub = Position.valueOf(positionSub);
        this.tier = Tier.valueOf(tier);

    }

    private int id;

    private String name;

    private Position positionMain;

    private Position positionSub;

    private Tier tier;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPositionMainPoint(){
        return this.positionMain.getPoint();
    }

    public String getPositionMain(){
        return this.positionMain.name();
    }

    public void setPositionMain(String  position){
        this.positionMain = Position.valueOf(position);
    }

    public int getPositionSubPoint(){
        return this.positionSub.getPoint();
    }

    public String getPositionSub(){
        return this.positionSub.name();
    }

    public int getTierPoint(){
        return this.tier.getPoint();
    }

    public void setPositionSub(String position){
        this.positionSub = Position.valueOf(position);

    }

    public String getTier(){
        return this.tier.name();
    }

    public void setTier(String tier){
        this.tier = Tier.valueOf(tier);
    }


}

