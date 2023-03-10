package com.jw.teammakter.domain.v2;

import com.jw.teammakter.domain.Position;
import com.jw.teammakter.domain.Tier;

public class PlayerV2 {

    public PlayerV2(){};

    public PlayerV2(String playerName, String positionMain, String positionSub, String tier){
        this.playerName = playerName;
        this.positionMain = Position.valueOf(positionMain);
        this.positionSub = Position.valueOf(positionSub);
        this.tier = Tier.valueOf(tier);
    }

    private int id;

    private String playerName;

    private Position positionMain;

    private Position positionSub;

    private Tier tier;

    private boolean team;

    public void setTeam(boolean team) {
        this.team = team;
    }

    public boolean getTeam() {
        return team;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public void setPlayerName(String name){
        this.playerName = name;
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

    public int getTierPointMain(){
        return this.tier.getPoint();
    }

    /*Sub Position tier point = Main Position tier point - 10 */
    public int getTierPointSub(){
        return (this.tier.getPoint() - 10);
    }

    public void setTier(String tier){
        this.tier = Tier.valueOf(tier);
    }


}

