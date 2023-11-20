package com.jw.teammaker.common.util;

import com.jw.teammaker.domain.Player;

import java.util.Comparator;

/**
 * PlayerComparator
 * 플레이어 List 내림차순 정렬 (default)
 * */
public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        if(p1.getEvaluationPoint() > p2.getEvaluationPoint())return -1;
        else if(p1.getEvaluationPoint() < p2.getEvaluationPoint())return 1;
        return 0;
    }
}
