package com.jw.teammakter.repository;

import com.jw.teammakter.domain.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMakerRepository implements MakerRepository{

    public static final List<Player> PLAYER = new ArrayList<>();

    /*sample data 10 players*/
    Player player1 = new Player(1,"player1", "SUPPORTER","iron");
    Player player2 = new Player(2,"player2","TOP","bronze");
    Player player3 = new Player(3,"player3", "JUNGLE","silver");
    Player player4 = new Player(4,"player4", "JUNGLE","silver");
    Player player5 = new Player(5,"player5", "ADCARRY","silver");
    Player player6 = new Player(6,"player6", "JUNGLE","gold4");
    Player player7 = new Player(7,"player7","APCARRY","gold4");
    Player player8 = new Player(8,"player8","ADCARRY","diamond1");
    Player player9 = new Player(9,"player9", "TOP","platinum4");
    Player player10 = new Player(10,"player10","APCARRY","gold1");

    public List<Player> getPlayerAll(){

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


        return PLAYER;
    }

}
