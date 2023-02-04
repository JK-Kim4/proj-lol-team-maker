package com.jw.teammakter.repository;

import com.jw.teammakter.domain.Player;
import com.jw.teammakter.domain.PlayerV2;

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
}
