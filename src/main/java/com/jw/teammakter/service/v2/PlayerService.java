package com.jw.teammakter.service.v2;

import com.jw.teammakter.domain.Position;
import com.jw.teammakter.domain.v2.PlayerV2;
import com.jw.teammakter.domain.v2.PositionGroup;
import com.jw.teammakter.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        try {
            return playerRepository.getPlayerList();
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<PositionGroup> separateWithPosition(List<PlayerV2> parameter){
        List<PositionGroup> resultList = new ArrayList<>();
        /*올라운더 임의 포지션 배정*/
        assignPositionForAllRounder(parameter);
        // 포지션 별 그룹 분배
        // 01-1. 메인 포지션 별로 그룹핑
        Position.stream().forEach(position -> {
            PositionGroup pg = new PositionGroup(position);
            for(PlayerV2 playerV2 : parameter){
                if(playerV2.getPositionMain().equals(position.name())){
                    pg.addPlayer(playerV2);
                }
            }
            resultList.add(pg);
        });

        List<PlayerV2> leftPlayerList = new ArrayList<>();
        // 02-1.각 포지션 별 2명 플레이어만 할당
        for (PositionGroup pg : resultList){
            if (pg.getPlayerOnPosition().size() > 2){
                do{
                    int index = (int) (Math.random() * pg.getPlayerOnPosition().size());
                    leftPlayerList.add(pg.getPlayerOnPosition().remove(index));
                }while (pg.getPlayerOnPosition().size() != 2);
            }
        }

        for (PositionGroup pg : resultList){
            if (pg.getPlayerOnPosition().size() == 0 || pg.getPlayerOnPosition().size() == 1){
                do{
                    int index = (int) (Math.random() * leftPlayerList.size());
                    pg.addPlayer(leftPlayerList.get(index));
                }while (pg.getPlayerOnPosition().size() != 2);
            }
        }
        // return result = 5 Position Group have 2 players each
        return resultList;
    }

    private static void assignPositionForAllRounder(List<PlayerV2> playerList) {
        playerList.stream()
                .filter(player -> Position.ALLROUNDER.name().equals(player.getPositionMain()))
                .forEach(player -> {
                    String position = Position.alignRandomPositionForAllRounder();
                    player.setPositionMain(position);
                    player.setPositionSub(position);
                });
    }

    public int delete(int playerId) {
        return playerRepository.delete(playerId);
    }

    private boolean getBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

}
