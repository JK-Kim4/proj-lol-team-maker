package com.jw.teammaker;

import com.jw.teammaker.entity.Player;
import com.jw.teammaker.entity.enumtype.Position;
import com.jw.teammaker.entity.enumtype.Tier;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import com.jw.teammaker.presentation.dto.PlayerUpdateDto;
import com.jw.teammaker.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@ActiveProfiles("dev")
public class PlayerServiceTest {

    @Autowired
    PlayerService playerService;

    @Test
    public void player_save_and_find_test(){
        //given
        PlayerSaveDto dto = new PlayerSaveDto();
        dto.setName("player");
        dto.setMainTier(Tier.BRONZE.name());
        dto.setMainPosition(Position.JNG.name());
        dto.setSubPosition(Position.MID.name());

        System.out.println("dto = " + dto.toString());

        //when
        Long result = playerService.save(dto);

        Player player = playerService.findById(result);


        //then
        System.out.println("save result = " + result);
        System.out.println("player id = " +player.getId());


    }

    @Test
    public void player_save_and_update_test(){
        //given
        PlayerSaveDto dto = new PlayerSaveDto();
        dto.setName("player");
        dto.setName("player");
        dto.setMainPosition(Position.JNG.name());
        dto.setMainTier(Tier.GOLD.name());
        dto.setSubPosition(Position.MID.name());
        dto.setSubTier(Tier.SILVER.name());

        Long result = playerService.save(dto);

        PlayerUpdateDto updateDto = new PlayerUpdateDto();
        updateDto.setPlayerId(result);
        updateDto.setNickName("updatePlayer");
        updateDto.setMainPosition(Position.MID.name());
        updateDto.setMainTier(Tier.BRONZE.name());
        updateDto.setSubPosition(Position.TOP.name());
        updateDto.setSubTier(Tier.CHALLENGER.name());

        //when
        playerService.updatePlayer(updateDto);

        //then
        Player player = playerService.findById(result);

        System.out.println("update result = " + player.toString());

    }

    @Test
    public void player_delete_test(){
        //given
        PlayerSaveDto dto = new PlayerSaveDto();
        dto.setName("player");
        dto.setMainTier(Tier.SEMIPRO.name());
        dto.setMainPosition(Position.JNG.name());
        dto.setSubPosition(Position.MID.name());

        //when
        Long result = playerService.save(dto);
        playerService.delete(result);
        List<Player> players = playerService.findAll();

        //then
        System.out.println("player size = " + players.size());

    }
}
