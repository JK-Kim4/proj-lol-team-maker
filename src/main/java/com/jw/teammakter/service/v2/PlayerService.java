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

        // 포지션 별 그룹 분배
        // 01-1. 메인 포지션 별로 그룹핑
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

        // 01-2. Position.ALLROUNDER 임의 그룹 배정 진행


        // 02-1. 각 포지션 별 2명 선별
        // 02-2. 초과 인원 sub position 재분배




        // return result = 5 Position Group have 2 players each
        return resultList;
    }

    public int delete(int playerId) {
        return playerRepository.delete(playerId);
    }
}
