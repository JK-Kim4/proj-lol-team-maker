package com.jw.teammakter.service;

import com.jw.teammakter.domain.Player;
import com.jw.teammakter.domain.PlayerOnTeam;
import com.jw.teammakter.domain.PlayerWithRating;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MakerService {
    public List<PlayerOnTeam> makeTeam(ArrayList<Player> info) {
        List<PlayerOnTeam> result = new ArrayList<>();
        List<PlayerWithRating> playerWithRatings = parsePlayerWithRating(info);
        result = sortPlayerByRating(playerWithRatings);


        return result;
    }


    private List<PlayerWithRating> parsePlayerWithRating(List<Player> players){
        List<PlayerWithRating> result = new ArrayList<>();
        players.forEach(player -> {
            result.add(new PlayerWithRating(player));
        });
        return result;
    }

    private List<PlayerOnTeam> sortPlayerByRating(List<PlayerWithRating> players){
        List<PlayerOnTeam> result = new ArrayList<>();

        for(int i = 0; i < players.size(); i++){
            PlayerWithRating temp = players.get(i);
            for(int j = i+1; j < players.size(); j++){
                if(temp.getTotalRating() > players.get(j).getTotalRating()){
                    players.add(i, players.get(j));
                    players.add(j, temp);
                }else if(temp.getTotalRating() == players.get(j).getTotalRating()){
                    continue;
                }
            }
        }

        players.forEach(player -> {
            System.out.println("sorting result player name = "+ player.getPlayerName() + ", rating = " + player.getTotalRating());
        });

        return result;
    }
}
