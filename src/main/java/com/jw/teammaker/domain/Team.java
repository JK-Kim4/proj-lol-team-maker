package com.jw.teammaker.domain;

import com.jw.teammaker.exception.DuoIndexOutOfBoundsException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class Team {

    private List<Player> players = new ArrayList<>();

    private float totalPoint;

    private float teamAveragePoint;

    //듀오 슬롯 추가 (최대 2)
    private Duo[] duoSlot = new Duo[2];


    /*public methods*/
    public void addPlayer(Player player){
        //플레이어 추가 후 팀 평균 점수 계산
        this.players.add(player);
        this.totalPoint += (float) player.getEvaluationPoint();
        this.teamAveragePoint = this.totalPoint / (float) getSoloPlayerSize();
    }

    public void addDuo(Duo duo) throws ArrayIndexOutOfBoundsException{
        try {
            if(getDuoCount() == 0){
                this.duoSlot[0] = duo;
            }else{
                this.duoSlot[getDuoCount()] = duo;
            }

            addTeamTotalPoint(duo.getDuoTotalPoint());
            this.teamAveragePoint = this.totalPoint / ((this.duoSlot.length * 2) + (float) getSoloPlayerSize());
        }catch (ArrayIndexOutOfBoundsException e){
            throw new DuoIndexOutOfBoundsException("한 팀에 듀오큐는 최대 2개까지만 가능합니다.");
        }
    }

    public int getDuoCount(){
        int cnt = 0;
        for(Duo d: duoSlot){
            if(d != null) cnt++;
        }
        return cnt;
    }

    /*private methods*/
    private void addTeamTotalPoint(float point){
        this.totalPoint += point;
    }

    private int getSoloPlayerSize(){
        return this.players.size();
    }
}
