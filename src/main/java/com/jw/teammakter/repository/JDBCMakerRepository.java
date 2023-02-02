package com.jw.teammakter.repository;

import com.jw.teammakter.domain.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCMakerRepository implements MakerRepository{

    private final JdbcTemplate jdbcTemplate;

    public JDBCMakerRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Player addPlayer(Player player) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("user").usingGeneratedKeyColumns("id");

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("name", player.getPlayerName());
        parameter.put("position", player.getPositionPoint());
        parameter.put("tier", player.getTierPoint());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameter));
        player.setId(key.intValue());
        return player;
    }

    @Override
    public List<Player> getPlayerAll() {
        List<Player> resultList = jdbcTemplate.query("select * from user",  playerRowMapper());
        return resultList;
    }

    @Override
    public List<Player> getPlayerByIds(List<Integer> ids) {
        return jdbcTemplate.query("select * from name where id in (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", playerRowMapper(),
                ids.get(0),ids.get(1),ids.get(2),ids.get(3),ids.get(4),ids.get(5),ids.get(6),ids.get(7),ids.get(8),ids.get(9));
    }

    private RowMapper<Player> playerRowMapper(){
        return (rs, rowNum) -> {
            Player player = new Player();
            player.setId(rs.getInt("id"));
            player.setPlayerName(rs.getString("name"));
            player.setPosition(rs.getString("position"));
            player.setTier(rs.getString("tier"));
            return player;
        };
    }
}
