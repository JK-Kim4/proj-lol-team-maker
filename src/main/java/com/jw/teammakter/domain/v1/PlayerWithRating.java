package com.jw.teammakter.domain.v1;

public class PlayerWithRating {

    public PlayerWithRating(Player player){
        this.playerName = player.getPlayerName();
        this.totalRating = (player.getPositionPoint() + player.getTierPoint());
    }

    private String playerName;
    private int totalRating;

    public int getTotalRating(){
        return this.totalRating;
    }

    public String getPlayerName(){
        return this.playerName;
    }
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    public void setTotalRating(int totalRating){
        this.totalRating = totalRating;
    }

}
