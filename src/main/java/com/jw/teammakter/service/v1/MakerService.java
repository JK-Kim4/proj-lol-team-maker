package com.jw.teammakter.service.v1;

import com.jw.teammakter.domain.v1.Player;
import com.jw.teammakter.domain.v1.PlayerOnTeam;
import com.jw.teammakter.domain.v1.PlayerWithRating;
import com.jw.teammakter.domain.v2.PlayerV2;
import com.jw.teammakter.domain.v2.PositionGroup;
import com.jw.teammakter.repository.MakerRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MakerService {

    private MakerRepository makerRepository;


    public MakerService(MakerRepository makerRepository){
        this.makerRepository = makerRepository;
    }

    public List<Player> getPlayersById(List<Integer> ids){
        List<Player> result = makerRepository.getPlayerByIds(ids);
        return result;
    }


    public List<PlayerOnTeam> makeTeam(List<Player> info) {
        List<PlayerOnTeam> result = new ArrayList<>();
        List<PlayerWithRating> playerWithRatings = parsePlayerWithRating(info);
        result = balancedPartition(playerWithRatings);

        return result;
    }


    private List<PlayerWithRating> parsePlayerWithRating(List<Player> players){
        List<PlayerWithRating> result = new ArrayList<>();
        players.forEach(player -> {
            result.add(new PlayerWithRating(player));
        });
        return result;
    }

    private List<PlayerOnTeam> balancedPartition(List<PlayerWithRating> players){
        //total rating 오름차순 정렬
        Comparator<PlayerWithRating> cp = getComparator();
        Collections.sort(players, cp);
        return separatePlayers(players);
    }

    private static Comparator<PlayerWithRating> getComparator() {
        Comparator<PlayerWithRating> cp = new Comparator<PlayerWithRating>() {
            @Override
            public int compare(PlayerWithRating o1, PlayerWithRating o2) {
                int total1 = o1.getTotalRating();
                int total2 = o2.getTotalRating();
                if(total1 > total2){
                    return 1;
                }else{
                    return -1;
                }
            }
        };
        return cp;
    }

    private List<PlayerOnTeam> separatePlayers(List<PlayerWithRating> players) {
        List<PlayerOnTeam> result = new ArrayList<>();
        for(int i = 0; i < players.size(); i++){
            if(i == 0 || i == 9 || i == 2 || i == 7 || i == 4){
                result.add(new PlayerOnTeam(players.get(i), 1));
            }else {
                result.add(new PlayerOnTeam(players.get(i), 0));
            }
        }
        return result;
    }

    public List<Player> getPlayerAll(){
        return makerRepository.getPlayerAll();
    }

    public List<PlayerV2> getPlayerV2All(){return makerRepository.getPlayerV2All();}

    public Player insertPlayer(Player player) {
        return makerRepository.save(player);
    }

    public void deletePlayer(int id) {
        makerRepository.delete(id);
    }



    public PositionGroup assignPositionForPlayers(List<PlayerV2> players){

        Map<String, Object> tempMap = new HashMap<>();
        /*PositionGroup pg = new PositionGroup();*/

        /*players.forEach(player ->{
            if(Position.TOP.equals(player.getPositionMain())){
                pg.addTopGroup(player);
            }else if(Position.JUNGLE.equals(player.getPositionMain())){
                pg.addJungleGroup(player);
            }else if(Position.APCARRY.equals(player.getPositionMain())){
                pg.addApGroup(player);
            }else if(Position.ADCARRY.equals(player.getPositionMain())){
                pg.addAdGroup(player);
            }else if(Position.SUPPORTER.equals(player.getPositionMain())){
                pg.addSupGroup(player);
            }else{
                pg.addAllGroup(player);
            }
        });*/

        return null;
    }
}
