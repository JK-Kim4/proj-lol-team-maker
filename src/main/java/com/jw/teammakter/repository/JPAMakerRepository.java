package com.jw.teammakter.repository;

import com.jw.teammakter.domain.Player;

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
    public List<Player> getPlayerByIds(List<Integer> ids) {
        return null;
    }
}
