package com.jw.teammakter.service;

import com.jw.teammakter.domain.Player;
import com.jw.teammakter.domain.PlayerOnTeam;
import com.jw.teammakter.domain.PlayerWithRating;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MakerService {
    public List<PlayerOnTeam> makeTeam(List<Player> info) {
        System.out.println("make team start");
        List<PlayerOnTeam> result = new ArrayList<>();
        List<PlayerWithRating> playerWithRatings = parsePlayerWithRating(info);
        result = sortPlayerByRating(playerWithRatings);
        System.out.println("make team end");
        return result;
    }


    private List<PlayerWithRating> parsePlayerWithRating(List<Player> players){
        System.out.println("parsePlayerWithRating start");
        List<PlayerWithRating> result = new ArrayList<>();
        players.forEach(player -> {
            result.add(new PlayerWithRating(player));
        });
        System.out.println("parsePlayerWithRating end");
        return result;
    }

    private List<PlayerOnTeam> sortPlayerByRating(List<PlayerWithRating> players){
        List<PlayerOnTeam> result = new ArrayList<>();
        System.out.println("sortPlayerByRating start");
        for(int i = 0; i < players.size(); i++){
            PlayerWithRating temp = players.get(i);
            for(int j = i+1; j < players.size(); j++){
                if(temp.getTotalRating() > players.get(j).getTotalRating()){
                    Collections.swap(players, i ,j);
                }else if(temp.getTotalRating() == players.get(j).getTotalRating()){
                    continue;
                }
            }
        }
        System.out.println("sortPlayerByRating end");

        players.forEach(player -> {
            System.out.println("sorting result player name = "+ player.getPlayerName() + ", rating = " + player.getTotalRating());
        });

        return result;
    }
}
