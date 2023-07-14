package com.jw.teammaker.domain;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private List<Player> players = new ArrayList<>();

    private int totalPoint;

    public void addPlayer(Player player){
        this.players.add(player);
    }
}
