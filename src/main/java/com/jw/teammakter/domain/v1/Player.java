package com.jw.teammakter.domain.v1;

import com.jw.teammakter.domain.Position;
import com.jw.teammakter.domain.Tier;

public class Player {

    public Player(){};

    public Player(int id, String playerName, String position, String tier){
        this.id = id;
        this.playerName = playerName;
        this.position = Position.valueOf(position);
        this.tier = Tier.valueOf(tier);
    }

    private int id;
    private String playerName;
    private Position position;
    private Tier tier;

    public int getId(){
        return this.id;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getPositionPoint(){
        return this.position.getPoint();
    }

    public String getPositionName(){
        return this.position.name();
    }

    public int getTierPoint(){
        return this.tier.getPoint();
    }

    public String getTierName(){
        return this.tier.name();
    }

    public void setId(int id){
        this.id = id;
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public void setPosition(String position){
        this.position = Position.valueOf(position);
    }

    public void setTier(String tier){
        this.tier = Tier.valueOf(tier);
    }
}
