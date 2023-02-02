package com.jw.teammakter.repository;

import com.jw.teammakter.domain.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakerRepository {

    Player addPlayer(Player player);

    List<Player> getPlayerAll();

    List<Player> getPlayerByIds(List<Integer> ids);
}
