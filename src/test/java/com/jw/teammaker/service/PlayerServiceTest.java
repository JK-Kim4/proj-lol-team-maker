package com.jw.teammaker.service;

import com.jw.teammaker.domain.Player;
import com.jw.teammaker.domain.enumtype.Position;
import com.jw.teammaker.domain.enumtype.Tier;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import com.jw.teammaker.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("dev")
@Transactional
public class PlayerServiceTest {

    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerRepository playerRepository;

    @Test
    public void save_player_test(){
        //given
        PlayerSaveDto dto = new PlayerSaveDto();
        dto.setName("tester");
        dto.setMainPosition(Position.AD.name());
        dto.setMainTier(Tier.GOLD.name());
        dto.setSubPosition(Position.MID.name());
        dto.setSubTier(Tier.BRONZE.name());
        dto.setNickName("testser");

        Long savedId = playerService.save(dto);

        //when
        Player player = playerRepository.findById(savedId);

        //then
        System.out.println("insert player desc = " +player.toString());

    }


}
