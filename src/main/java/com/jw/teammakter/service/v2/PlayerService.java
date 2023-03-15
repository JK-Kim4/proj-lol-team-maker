package com.jw.teammakter.service.v2;

import com.jw.teammakter.domain.Position;
import com.jw.teammakter.domain.Team;
import com.jw.teammakter.domain.v2.PlayerV2;
import com.jw.teammakter.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

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
            List<PlayerV2> result = playerRepository.getPlayerList();
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Map<String, List<PlayerV2>> separateWithPosition(List<PlayerV2> parameter){
        int totalRate = 0;

        for(PlayerV2 p : parameter){
            totalRate += (p.getPositionMainPoint() + p.getTierPoint());
        }
        /*올라운더 임의 포지션 배정*/
        assignPositionForAllRounder(parameter);
        // 포지션 별 그룹 분배
        // 01-1. 메인 포지션 별로 그룹핑
        System.out.println("================== 선택 플레이어 메인 포지션 할당 START ==================");
        Map<String, List<PlayerV2>> map = parameter.stream().collect(Collectors.groupingBy(PlayerV2::getPositionMain));
        System.out.println("================== 선택 플레이어 메인 포지션 할당 END ==================");


        System.out.println("================== 각 포지션 별 플레이어 2명 제한 START ==================");
        List<PlayerV2> leftPlayerList = new ArrayList<>();
        map.forEach((s, playerList) -> {
            while (playerList.size() > 2){
                int index = (int) (Math.random() * playerList.size());
                leftPlayerList.add(playerList.remove(index));
            }
        });
        System.out.println("================== 각 포지션 별 플레이어 2명 제한 END ==================");


        System.out.println("================== 미할당 플레이어 서브 포지션 기준 할당 START ==================");
        for(PlayerV2 playerV2 : leftPlayerList){
            List<PlayerV2> playerList =  map.get(playerV2.getPositionSub());
            if(playerList == null){
                List<PlayerV2> subPositionPlayer = new ArrayList<>();
                subPositionPlayer.add(playerV2);
                map.put(playerV2.getPositionSub(), subPositionPlayer);
            }else if (playerList.size() == 1 ){
                playerList.add(playerV2);
                map.put(playerV2.getPositionSub(), playerList);
            }else {
                continue;
            }
        }
        System.out.println("================== 미할당 플레이어 서브 포지션 기준 할당 END ==================");


        System.out.println("================== 미할당 플레이어 임의 포지션 할당 START ==================");
        // 02-1.각 포지션 별 2명 플레이어만 할당
        map.forEach((s, playerList) -> {
            if(playerList.isEmpty()){
                List<PlayerV2> nonPlayer = new ArrayList<>();
                for(int i = 0; i < 2; i++){
                    int index = (int) (Math.random() * leftPlayerList.size());
                    nonPlayer.add(leftPlayerList.remove(index));
                }
                playerList = nonPlayer;
            }else if(playerList.size() == 1){
                int index = (int) (Math.random() * leftPlayerList.size());
                playerList.add(leftPlayerList.remove(index));
            }
        });
        System.out.println("================== 미할당 플레이어 임의 포지션 할당 END ==================");
        assignTeamToEachPlayer(map);
        // return result = 5 Position Group have 2 players each
        return map;
    }

    public List<Team> assignTeamToEachPlayer(Map<String, List<PlayerV2>> param){
        List<Team> result = new ArrayList<>();
        int avgRating = 0;

        for(String key : param.keySet()){
            List<PlayerV2> playerV2List = param.get(key);
            for(PlayerV2 p : playerV2List){
                avgRating += (p.getTierPoint() + p.getPositionMainPoint());
            }
        }

        avgRating = avgRating/10;

        System.out.println("total Rating = " + avgRating);

        return result;
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
