package com.jw.teammakter.domain;

public class PlayerOnTeam {

    public PlayerOnTeam(PlayerWithRating player){
        this.player = player;
    }

    private PlayerWithRating player;

    private int team;

    public int getTeam(){
        return this.team;
    }

    public void setTeam(int team){
        this.team = team;
    }

}
