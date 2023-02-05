package com.jw.teammakter;

import com.jw.teammakter.domain.PlayerV2;
import com.jw.teammakter.domain.PositionGroup;
import com.jw.teammakter.service.MakerService;
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

        pg.getTopGroup().stream().forEach(System.out::println);
        System.out.println("====");
        pg.getJungleGroup().stream().forEach(System.out::println);
        System.out.println("====");
        pg.getApGroup().stream().forEach(System.out::println);
        System.out.println("====");
        pg.getAdGroup().stream().forEach(System.out::println);
        System.out.println("====");
        pg.getSupGroup().stream().forEach(System.out::println);
        System.out.println("====");
        pg.getAllGroup().stream().forEach(System.out::println);


    }
}
