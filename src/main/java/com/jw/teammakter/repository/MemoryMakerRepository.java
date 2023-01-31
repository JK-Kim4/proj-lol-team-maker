package com.jw.teammakter.repository;

import com.jw.teammakter.domain.Player;

import java.util.ArrayList;
import java.util.List;


public class MemoryMakerRepository implements MakerRepository{

    public static final List<Player> PLAYER = new ArrayList<>();

    /*sample data 10 players*/
    Player player1 = new Player(1,"player1", "SUPPORTER","IRON");
    Player player2 = new Player(2,"player2","TOP","BRONZE");
    Player player3 = new Player(3,"player3", "JUNGLE","SILVER");
    Player player4 = new Player(4,"player4", "JUNGLE","SILVER");
    Player player5 = new Player(5,"player5", "ADCARRY","SILVER");
    Player player6 = new Player(6,"player6", "JUNGLE","GOLD4");
    Player player7 = new Player(7,"player7","APCARRY","GOLD4");
    Player player8 = new Player(8,"player8","ADCARRY","DIAMOND1");
    Player player9 = new Player(9,"player9", "TOP","PLATINUM4");
    Player player10 = new Player(10,"player10","APCARRY","GOLD1");

    public MemoryMakerRepository(){
        PLAYER.add(player1);
        PLAYER.add(player2);
        PLAYER.add(player3);
        PLAYER.add(player4);
        PLAYER.add(player5);
        PLAYER.add(player6);
        PLAYER.add(player7);
        PLAYER.add(player8);
        PLAYER.add(player9);
        PLAYER.add(player10);
    }

    @Override
    public List<Player> getPlayerAll(){
        return PLAYER;
    }

    @Override
    public int addPlayer(Player player){
        PLAYER.add(player);
        return PLAYER.size();
    }

}
