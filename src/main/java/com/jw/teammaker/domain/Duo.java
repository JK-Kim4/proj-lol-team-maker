package com.jw.teammaker.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Duo {

    private List<Player> duoPlayerList = new ArrayList<>();

    private Integer duoTotalPoint;
    private Integer duoAveragePoint;

    public void addPlayer(Player player){
        this.duoPlayerList.add(player);
        this.duoTotalPoint += player.getEvaluationPoint();
        this.duoAveragePoint = duoTotalPoint / duoPlayerList.size();
    }

}
