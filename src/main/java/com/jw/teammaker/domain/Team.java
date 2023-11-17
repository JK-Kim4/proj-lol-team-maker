package com.jw.teammaker.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Team {

    private List<Player> players = new ArrayList<>();

    private int totalPoint;

    private int teamAveragePoint;

    //듀오 슬롯 추가 (최대 2)
    private Duo[] duoSlot = new Duo[2];


    public void addPlayer(Player player){
        //플레이어 추가 후 팀 평균 점수 계산
        this.players.add(player);
        this.totalPoint += player.getEvaluationPoint();
        this.teamAveragePoint = this.totalPoint / players.size();
    }

    public void calculateTotalPoint(){
        for(Player p : this.players){
            this.totalPoint += p.getEvaluationPoint();
        }
    }

    public void addDuo(Duo duo){
        this.duoSlot[duoSlot.length] = duo;
    }
}
