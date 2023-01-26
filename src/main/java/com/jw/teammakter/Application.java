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
        Player player1 = new Player(1,"player1", 100,100);
        Player player2 = new Player(2,"player2", 100,100);
        Player player3 = new Player(3,"player3", 100,100);
        Player player4 = new Player(4,"player4", 100,100);
        Player player5 = new Player(5,"player5", 100,100);
        Player player6 = new Player(6,"player6", 100,100);
        Player player7 = new Player(7,"player7", 100,100);
        Player player8 = new Player(8,"player8", 100,100);
        Player player9 = new Player(9,"player9", 100,100);
        Player player10 = new Player(10,"player10", 100,100);

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
