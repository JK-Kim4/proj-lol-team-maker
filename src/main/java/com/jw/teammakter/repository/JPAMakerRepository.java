package com.jw.teammakter.repository;

import com.jw.teammakter.domain.v1.Player;
import com.jw.teammakter.domain.v2.PlayerV2;

import java.util.List;

public class JPAMakerRepository implements MakerRepository{

    @Override
    public Player save(Player player) {
        return null;
    }

    @Override
    public List<Player> getPlayerAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Player> getPlayerByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public List<PlayerV2> getPlayerV2All() {
        return null;
    }

    @Override
    public List<PlayerV2> getPlayerV2ByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public PlayerV2 saveV2(PlayerV2 playerV2) {
        return null;
    }
}
