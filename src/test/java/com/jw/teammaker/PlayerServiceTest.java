package com.jw.teammaker;

import com.jw.teammaker.entity.Player;
import com.jw.teammaker.entity.enumtype.Position;
import com.jw.teammaker.entity.enumtype.Tier;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import com.jw.teammaker.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class PlayerServiceTest {

    @Autowired
    PlayerService playerService;

    @Test
    public void player_save_test(){

        System.out.println("position = " +Position.valueOf(Position.BRONZE.toString()));

        //given
        PlayerSaveDto dto = new PlayerSaveDto();
        dto.setName("test");
        dto.setNickName("tester");
        dto.setTier(Tier.FIVE.toString());
        dto.setMainPosition(Position.BRONZE.toString());
        dto.setSubPosition(Position.SILVER.toString());

        System.out.println("dto = " +dto.toString());

        //when
        Long result = playerService.save(dto);


        System.out.println("player save result = " + result);


        //then
        Player findPlayer = playerService.findById(result);

        System.out.println("find player =" +findPlayer.toString());

    }
}
