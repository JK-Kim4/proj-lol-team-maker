package com.jw.teammaker.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    private List<Player> players = new ArrayList<>();

    private int totalPoint;

    public void addPlayer(Player player){
        this.players.add(player);
    }
}
