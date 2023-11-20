package com.jw.teammaker.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Duo {

    private Player[] players = new Player[2];

    private float duoTotalPoint;
    private float duoAveragePoint;

    public void addPlayer(Player player){
        if(getPlayerCount() == 0){
            this.players[0] = player;
            addTotalPoint(player);
        }else{
            this.players[getPlayerCount()] = player;
            addTotalPoint(player);
            calculationAveragePoint();
        }
    }

    public int getPlayerCount(){
        int cnt = 0;
        for(Player p: players){
            if(p != null) cnt ++;
        }
        return cnt;
    }

    private void addTotalPoint(Player player){
        this.duoTotalPoint += player.getEvaluationPoint();
    }

    private void calculationAveragePoint(){
        this.duoAveragePoint = this.duoTotalPoint / players.length;
    }
}
