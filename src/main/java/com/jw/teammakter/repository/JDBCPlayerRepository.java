package com.jw.teammakter.repository;

import com.jw.teammakter.domain.v2.PlayerV2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCPlayerRepository implements PlayerRepository{

    private final JdbcTemplate jdbcTemplate;

    public JDBCPlayerRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(PlayerV2 player) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("player_v2").usingGeneratedKeyColumns("id");

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("name", player.getPlayerName());
        parameter.put("position_main", player.getPositionMain());
        parameter.put("position_sub", player.getPositionSub());
        parameter.put("tier", player.getTier());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameter));
        return key.intValue();
    }

    @Override
    public List<PlayerV2> getPlayerList() {
        String query = "SELECT * FROM PLAYER_V2 P";
        return jdbcTemplate.query(query, playerMapper());
    }

    @Override
    public int delete(int playerId) {
        String query = "DELETE FROM PLAYER_V2 WHERE PLAYER_ID = " +playerId;
        return jdbcTemplate.update(query);
    }

    private RowMapper<PlayerV2> playerMapper(){
        return ((rs, rowNum) -> {
            PlayerV2 player = new PlayerV2();
            player.setId(rs.getInt("id"));
            player.setPlayerName(rs.getString("name"));
            player.setPositionMain(rs.getString("position_main"));
            player.setPositionSub(rs.getString("position_sub"));
            player.setTier(rs.getString("tier"));
            return player;
        });
    }
}
