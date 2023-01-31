package com.jw.teammakter.repository;

import com.jw.teammakter.domain.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakerRepository {

    int addPlayer(Player player);

    List<Player> getPlayerAll();

}
