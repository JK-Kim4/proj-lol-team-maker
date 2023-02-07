package com.jw.teammakter.repository;

import com.jw.teammakter.domain.v2.PlayerV2;

import java.util.List;

public interface PlayerRepository {

    int save(PlayerV2 playerV2);

    List<PlayerV2> getPlayerList();
}
