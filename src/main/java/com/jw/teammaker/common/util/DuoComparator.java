package com.jw.teammaker.common.util;

import com.jw.teammaker.domain.Duo;

import java.util.Comparator;

/**
 * DuoComparator
 * 듀오 List 평군 점수 내림차순 (default)
 * */
public class DuoComparator implements Comparator<Duo> {

    @Override
    public int compare(Duo duo1, Duo duo2) {
        if(duo1.getDuoAveragePoint() > duo2.getDuoAveragePoint()) return -1;
        else if (duo1.getDuoAveragePoint() < duo2.getDuoAveragePoint()) return 1;
        return 0;
    }
}
