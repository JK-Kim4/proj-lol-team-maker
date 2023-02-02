package com.jw.teammakter.service;

import com.jw.teammakter.domain.Player;
import com.jw.teammakter.domain.PlayerOnTeam;
import com.jw.teammakter.domain.PlayerWithRating;
import com.jw.teammakter.repository.MakerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MakerService {

    private MakerRepository makerRepository;


    public MakerService(MakerRepository makerRepository){
        this.makerRepository = makerRepository;
    }

    public List<Player> getPlayersById(List<Integer> ids){
        List<Player> result = makerRepository.getPlayerByIds(ids);
        /*makerRepository.PLAYER.stream().forEach(player -> {
            ids.stream().forEach(id->{
                if(player.getId() == id){
                    result.add(player);
                }
            });
        });*/
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
        List<PlayerOnTeam> result = new ArrayList<>();
        int index = 0;
        //total rating 오름차순 정렬
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

        Collections.sort(players, cp);

        for(PlayerWithRating player : players){

            System.out.println(player.getTotalRating());

            if(index == 0){
                result.add(new PlayerOnTeam(player, 0));
                index++;
            }else if(index == 1){
                result.add(new PlayerOnTeam(player, 1));
                index--;
            }
        }

        return result;
    }

    public List<Player> getPlayerAll() {
        return makerRepository.getPlayerAll();
    }

    public Player insertPlayer(Player player) {
        return makerRepository.addPlayer(player);
    }
}
