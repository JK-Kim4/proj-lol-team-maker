package com.jw.teammaker.domain;

import com.jw.teammaker.domain.enumtype.Position;
import com.jw.teammaker.domain.enumtype.Tier;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Dou Domain Unit Test
 *
 * */
public class DuoDomainTest {

    private Player duoPlayer0101 = new Player(getSamplePlayerSaveDto("testPlayer1", Position.MID.name(), Tier.SILVER.name()));
    private Player duoPlayer0102 = new Player(getSamplePlayerSaveDto("testPlayer2", Position.AD.name(), Tier.GOLD.name()));
    private Player duoPlayer0201 = new Player(getSamplePlayerSaveDto("testPlayer3", Position.TOP.name(), Tier.GOLD.name()));
    private Player duoPlayer0202 = new Player(getSamplePlayerSaveDto("testPlayer4", Position.SUP.name(), Tier.PLATINUM.name()));

    private Duo duoSlot1;
    private Duo duoSlot2;
    @Test
    public void 듀오플레이어_추가_테스트(){

        duoSlot1 = new Duo();
        duoSlot2 = new Duo();

        //Duo PlayerField null 여부 검증 필요
        assertEquals(duoSlot1.getPlayerCount(), 0);
        assertEquals(duoSlot1.getPlayerCount(), 0);

        duoSlot1.addPlayer(duoPlayer0101);
        assertEquals(duoSlot1.getPlayerCount(), 1);
        duoSlot1.addPlayer(duoPlayer0102);
        assertEquals(duoSlot1.getPlayerCount(), 2);
        duoSlot2.addPlayer(duoPlayer0201);
        assertEquals(duoSlot2.getPlayerCount(), 1);
        duoSlot2.addPlayer(duoPlayer0202);
        assertEquals(duoSlot2.getPlayerCount(), 2);

        assertEquals(2, duoSlot1.getPlayerCount());
        assertEquals(2, duoSlot2.getPlayerCount());
    }

    @Test
    public void 듀오플레이어_총점_평가점수_테스트(){

        duoSlot1 = new Duo();
        duoSlot2 = new Duo();

        duoSlot1.addPlayer(duoPlayer0101);
        duoSlot1.addPlayer(duoPlayer0102);
        duoSlot2.addPlayer(duoPlayer0201);
        duoSlot2.addPlayer(duoPlayer0202);

        assertEquals(duoSlot1.getDuoTotalPoint(), (float)(duoPlayer0101.getEvaluationPoint() + duoPlayer0102.getEvaluationPoint()));
        assertEquals(duoSlot2.getDuoTotalPoint(), (float)(duoPlayer0201.getEvaluationPoint() + duoPlayer0202.getEvaluationPoint()));
    }

    @Test
    public void 듀오플레이어_평균_평가점수_테스트(){

        duoSlot1 = new Duo();
        duoSlot2 = new Duo();

        duoSlot1.addPlayer(duoPlayer0101);
        duoSlot1.addPlayer(duoPlayer0102);
        duoSlot2.addPlayer(duoPlayer0201);
        duoSlot2.addPlayer(duoPlayer0202);

        assertEquals(duoSlot1.getDuoAveragePoint(), (float)(duoPlayer0101.getEvaluationPoint() + duoPlayer0102.getEvaluationPoint()) / duoSlot1.getPlayers().length);
        assertEquals(duoSlot2.getDuoAveragePoint(), (float)(duoPlayer0201.getEvaluationPoint() + duoPlayer0202.getEvaluationPoint()) / duoSlot2.getPlayers().length);
    }

    private PlayerSaveDto getSamplePlayerSaveDto(String name, String mainPosition, String mainTier){
        PlayerSaveDto sample = new PlayerSaveDto();
        sample.setNickName(name);
        sample.setName(name);
        sample.setMainPosition(mainPosition);
        sample.setMainTier(mainTier);
        sample.setSubPosition(mainPosition);
        sample.setSubTier(mainTier);
        return sample;
    }
}
