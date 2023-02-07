package com.jw.teammakter.repository;

import com.jw.teammakter.domain.v1.Player;
import com.jw.teammakter.domain.v2.PlayerV2;
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
    public void delete(int id) {
        jdbcTemplate.update("delete from player where id =" +id);
    }

    @Override
    public Player save(Player player) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("player").usingGeneratedKeyColumns("id");

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("name", player.getPlayerName());
        parameter.put("position", player.getPositionName());
        parameter.put("tier", player.getTierName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameter));
        player.setId(key.intValue());
        return player;
    }

    @Override
    public List<Player> getPlayerAll() {
        List<Player> resultList = jdbcTemplate.query("select * from player",  playerRowMapper());
        return resultList;
    }

    @Override
    public List<Player> getPlayerByIds(List<Integer> ids) {
        return jdbcTemplate.query("select * from player where id in (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", playerRowMapper(),
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


    /*Player V2*/
    @Override
    public List<PlayerV2> getPlayerV2All() {
        List<PlayerV2> resultList = jdbcTemplate.query("select * from player_v2",  playerV2RowMapper());
        return resultList;
    }

    @Override
    public List<PlayerV2> getPlayerV2ByIds(List<Integer> ids) {
        return jdbcTemplate.query("select * from player_v2 where id in (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", playerV2RowMapper(),
                ids.get(0),ids.get(1),ids.get(2),ids.get(3),ids.get(4),ids.get(5),ids.get(6),ids.get(7),ids.get(8),ids.get(9));
    }

    @Override
    public PlayerV2 saveV2(PlayerV2 playerV2) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

        insert.withTableName("player_v2").usingGeneratedKeyColumns("id");

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("name", playerV2.getName());
        parameter.put("positionMain", playerV2.getPositionMain());
        parameter.put("positionSub", playerV2.getPositionSub());
        parameter.put("tier", playerV2.getTier());

        Number key = insert.executeAndReturnKey(new MapSqlParameterSource(parameter));
        playerV2.setId(key.intValue());

        return playerV2;
    }

    private RowMapper<PlayerV2> playerV2RowMapper(){
        return (rs, rowNumber)-> {
            PlayerV2 v2 = new PlayerV2();
            v2.setId(rs.getInt("id"));
            v2.setName(rs.getString("name"));
            v2.setPositionMain(rs.getString("positionMain"));
            v2.setPositionSub(rs.getString("positionSub"));
            v2.setTier(rs.getString("tier"));
            return v2;
        };

    }

}
