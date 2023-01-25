package com.jw.teammakter.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerWithRating {

    public PlayerWithRating(Player player){
        this.playerName = player.getPlayerName();
        this.totalRating = (player.getPosition() + player.getTier());
    }

    private String playerName;
    private int totalRating;

}
