package com.jw.teammakter;

import com.jw.teammakter.domain.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static final List<Player> PLAYER = new ArrayList<>();

    public static void main(String[] args) {

        /*sample data 10 players*/
        Player player1 = new Player("player1", 100,100);
        Player player2 = new Player("player2", 100,100);
        Player player3 = new Player("player3", 100,100);
        Player player4 = new Player("player4", 100,100);
        Player player5 = new Player("player5", 100,100);
        Player player6 = new Player("player6", 100,100);
        Player player7 = new Player("player7", 100,100);
        Player player8 = new Player("player8", 100,100);
        Player player9 = new Player("player9", 100,100);
        Player player10 = new Player("player10", 100,100);

        List<Player> players = new ArrayList<>();

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



        SpringApplication.run(Application.class, args);
    }

}
