package com.jw.teammakter.domain;

public class Player {

    public Player(){};

    public Player(String playerName, int position, int tier){
        this.playerName = playerName;
        this.position = position;
        this.tier = tier;
    }

    private String playerName;
    private int position;
    private int tier;

    public String getPlayerName() {
        return this.playerName;
    }

    public int getPosition(){
        return this.position;
    }

    public int getTier(){
        return this.tier;
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public void setTier(int tier){
        this.tier = tier;
    }
}
