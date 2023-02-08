package com.jw.teammakter.domain.v2;

import com.jw.teammakter.domain.Position;

import java.util.ArrayList;
import java.util.List;

public class PositionGroup {

    private Position position;

    private List<PlayerV2> playerOnPosition = new ArrayList<>();


    public Position getPosition(){
        return this.position;
    }

    public String getPositionName(){
        return this.position.name();
    }

    public void setPosition(String position){
        this.position = Position.valueOf(position);
    }

    public void addPlayer(PlayerV2 playerV2){
        if(playerV2 != null){
            playerOnPosition.add(playerV2);
        }
    }

    public List<PlayerV2> getPlayerOnPosition(){
        return this.playerOnPosition;
    }

}
