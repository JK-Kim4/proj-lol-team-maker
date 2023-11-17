package com.jw.teammaker.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Duo {

    private Player[] players = new Player[2];

    private float duoTotalPoint;
    private float duoAveragePoint;

    public void addPlayer(Player player){
        if(isPlayerEmpty()){
            this.players[0] = player;
            addTotalPoint(player);
        }else{
            this.players[this.players.length] = player;
            addTotalPoint(player);
            calculationAveragePoint();
        }
    }

    public boolean isPlayerEmpty(){
        if(players.length > 0) return false;
        else return true;
    }

    private void addTotalPoint(Player player){
        this.duoTotalPoint += player.getEvaluationPoint();
    }

    private void calculationAveragePoint(){
        this.duoAveragePoint = this.duoTotalPoint / players.length;
    }
}
