package com.jw.teammakter.repository;

import com.jw.teammakter.domain.v1.Player;
import com.jw.teammakter.domain.v2.PlayerV2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakerRepository {

    Player save(Player player);

    List<Player> getPlayerAll();

    List<Player> getPlayerByIds(List<Integer> ids);

    void delete(int id);

    List<PlayerV2> getPlayerV2All();

    List<PlayerV2> getPlayerV2ByIds(List<Integer> ids);

    PlayerV2 saveV2(PlayerV2 playerV2);
}
