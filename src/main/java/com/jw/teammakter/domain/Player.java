package com.jw.teammakter.domain;

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

    public String getPlayerName() {
        return this.playerName;
    }

    public int getPositionPoint(){
        return this.position.getPoint();
    }

    public int getTierPoint(){
        return this.tier.getPoint();
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
