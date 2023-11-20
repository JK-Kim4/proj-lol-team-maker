package com.jw.teammaker.service;

import com.jw.teammaker.domain.Duo;
import com.jw.teammaker.domain.Player;
import com.jw.teammaker.domain.Team;
import com.jw.teammaker.domain.enumtype.Position;
import com.jw.teammaker.domain.enumtype.Tier;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import com.jw.teammaker.presentation.dto.PlayerUpdateDto;
import com.jw.teammaker.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        //TODO assertThat
        System.out.println("insert player desc = " +player.toString());

    }

    @Test
    public void find_player_all_test(){
        PlayerSaveDto dto = new PlayerSaveDto();
        dto.setName("tester1");
        dto.setMainPosition(Position.AD.name());
        dto.setMainTier(Tier.GOLD.name());
        dto.setSubPosition(Position.MID.name());
        dto.setSubTier(Tier.BRONZE.name());
        dto.setNickName("tester1");

        Long savedId1 = playerService.save(dto);
        dto.setName("tester2");
        dto.setNickName("tester2");
        Long savedId2 = playerService.save(dto);

        List<Player> playerList = playerRepository.findAll();

        for(Player p: playerList){
            //TODO assertThat
            System.out.println("insert player data = " + p.toString());
        }

    }

    @Test
    public void player_update_test(){
        PlayerSaveDto saveDto = new PlayerSaveDto();
        saveDto.setName("tester1");
        saveDto.setMainPosition(Position.AD.name());
        saveDto.setMainTier(Tier.GOLD.name());
        saveDto.setSubPosition(Position.MID.name());
        saveDto.setSubTier(Tier.BRONZE.name());
        saveDto.setNickName("tester1");

        Long savedId1 = playerService.save(saveDto);

        PlayerUpdateDto updateDto = new PlayerUpdateDto();
        updateDto.setPlayerId(savedId1);
        updateDto.setNickName("updateName");
        updateDto.setSubPosition(saveDto.getSubPosition());
        updateDto.setMainPosition(saveDto.getMainPosition());
        updateDto.setSubTier(saveDto.getSubTier());
        updateDto.setMainTier(Tier.CHALLENGER.name());

        Long updateId = playerService.updatePlayer(updateDto);

        Player player = playerRepository.findById(updateId);

        //then
        //TODO assertThat
        System.out.println("update player desc = " +player.toString());

    }

    @Test
    public void 듀오포함_팀분배_테스트(){
        List<Team> resultList = new ArrayList<>();
        List<Long[]> duoIdList = new ArrayList<>();
        Long[] playerList = {9L,10L};
        Long[] dou1 = {1L,2L};
        Long[] dou2 = {3L,4L};
        Long[] dou3 = {5L,6L};
        Long[] dou4 = {7L,8L};

        duoIdList.add(dou1);
        duoIdList.add(dou2);
        duoIdList.add(dou3);
        duoIdList.add(dou4);

        resultList = playerService.makeTeamsWithDuo(duoIdList, playerList, "default");

        for(Team t: resultList){
            for(Player p: t.getPlayers()){
                System.out.println(p.toString());
            }
            for(Duo d: t.getDuoSlot()){
                System.out.println("duo cnt = " +d.getPlayerCount());
            }
        }
    }


}
