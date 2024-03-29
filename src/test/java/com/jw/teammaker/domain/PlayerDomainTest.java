package com.jw.teammaker.domain;

import com.jw.teammaker.domain.enumtype.Position;
import com.jw.teammaker.domain.enumtype.Tier;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Player Domain Unit Test
 *
 * */
public class PlayerDomainTest {

    private Player samplePlayer = new Player(getSamplePlayerSaveDto());

    @Test
    public void 플레이어_평가점수_계산_테스트(){
        assertEquals(samplePlayer.getEvaluationPoint(), (float)(Position.JNG.getPoint() + Tier.GOLD.getPoint()));
    }


    private PlayerSaveDto getSamplePlayerSaveDto(){
        PlayerSaveDto sample = new PlayerSaveDto();
        sample.setNickName("sample player");
        sample.setName("sample");
        sample.setMainPosition(Position.JNG.name());
        sample.setMainTier(Tier.GOLD.name());
        sample.setSubPosition(Position.MID.name());
        sample.setSubTier(Tier.SILVER.name());
        return sample;
    }
}
