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
            PositionGroup pg = new PositionGroup();
            pg.setPosition(position.name());
            for(PlayerV2 player : parameter){
                if(player.getPositionMain().equals(position.name())){
                    pg.addPlayer(player);
                }
            }
            resultList.add(pg);
        });

        // 02-1. 각 포지션 별 2명 선별
        resultList.stream().forEach(positionGroup -> {

            //메인 포지션 인원 2명 이상인 경우 2명 남기고 재분배
            if(positionGroup.getPlayerOnPosition().size() > 2){
                List<PlayerV2> temp = positionGroup.getPlayerOnPosition();
                int player1 = 0;
                int player2 = 0;
                do{
                    player1 = (int) (Math.random() * temp.size()) + 1;
                    player2 = (int) (Math.random() * temp.size()) + 1;
                }while (player1 == player2);

                System.out.println("player size = " +temp.size());
                System.out.println("player1 = " +player1);
                System.out.println("player2 = " +player2);

            }

        });

        // 02-2. 초과 인원 sub position 재분배




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
