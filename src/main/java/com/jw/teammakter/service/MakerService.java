package com.jw.teammakter.service;

import com.jw.teammakter.domain.Player;
import com.jw.teammakter.domain.PlayerOnTeam;
import com.jw.teammakter.domain.PlayerWithRating;
import com.jw.teammakter.repository.MemoryMakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MakerService {

    private MemoryMakerRepository makerRepository;

    @Autowired
    public MakerService(final MemoryMakerRepository makerRepository){
        this.makerRepository = makerRepository;
    }

    public List<PlayerOnTeam> makeTeam(List<Player> info) {
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
                        Collections.swap(players, i ,j);
                    }else if(temp.getTotalRating() == players.get(j).getTotalRating()){
                        continue;
                    }
                }
            }

            int index = 0;
            for(PlayerWithRating player : players){
                if(index == 0 || index == 2 || index == 4 || index == 6 || index == 9) {
                    result.add(new PlayerOnTeam(player, 1));
                }else{
                    result.add(new PlayerOnTeam(player, 0));
                }
                index++;
            }

            return result;
    }

    public List<Player> getPlayerAll() {
        return makerRepository.getPlayerAll();
    }

    public int insertPlayer(Player player) {
        return makerRepository.addPlayer(player);
    }
}
