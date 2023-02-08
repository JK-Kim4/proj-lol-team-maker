package com.jw.teammakter.service.v2;

import com.jw.teammakter.domain.Position;
import com.jw.teammakter.domain.v2.PlayerV2;
import com.jw.teammakter.domain.v2.PositionGroup;
import com.jw.teammakter.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
    public class PlayerService {
        private PlayerRepository playerRepository;

        public PlayerService(PlayerRepository playerRepository){
            this.playerRepository = playerRepository;
        }

        public int insertPlayerV2(PlayerV2 playerV2) {
        return playerRepository.save(playerV2);
    }

    public List<PlayerV2> getPlayerList(){
        List<PlayerV2> result = new ArrayList<>();
        try {
            result = playerRepository.getPlayerList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List<PositionGroup> separateWithPosition(List<PlayerV2> playerList){

        List<PositionGroup> resultList = new ArrayList<>();

        Position.stream().forEach(position -> {
            PositionGroup pg = new PositionGroup();
            pg.setPosition(position.name());
            for(PlayerV2 player : playerList){
                if(player.getPositionMain().equals(position.name())){
                    pg.addPlayer(player);
                }
            }
            resultList.add(pg);
        });



        return resultList;
    }
}
