package com.jw.teammakter;

import com.jw.teammakter.domain.v2.PlayerV2;
import com.jw.teammakter.domain.v2.PositionGroup;
import com.jw.teammakter.service.v1.MakerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@ActiveProfiles("dev")
@Transactional
public class ServiceTest {

    @Autowired
    MakerService makerService;


    @Test
    public void 포지션그룹_생성_테스트(){

        List<PlayerV2> players = makerService.getPlayerV2All();
        PositionGroup pg = makerService.assignPositionForPlayers(players);


    }
}
