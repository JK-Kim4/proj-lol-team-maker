package com.jw.teammakter.domain;

public class PlayerOnTeam {

    public PlayerOnTeam(PlayerWithRating player){
        this.player = player;
    }
    public PlayerOnTeam(PlayerWithRating player, int team){
        this.player = player;
        this.team = team;
    }

    private PlayerWithRating player;

    private int team;

    public PlayerWithRating getPlayer(){
        return this.player;
    }

    public void setPlayer(PlayerWithRating player){
        this.player = player;

    }

    public int getTeam(){
        return this.team;
    }

    public void setTeam(int team){
        this.team = team;
    }

}
