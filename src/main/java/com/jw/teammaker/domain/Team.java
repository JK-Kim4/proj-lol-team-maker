package com.jw.teammaker.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class Team {

    private List<Player> players = new ArrayList<>();

    private int totalPoint;

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void sumTotalPoint(int playerEvePoint){
        this.totalPoint += playerEvePoint;
    }
}
