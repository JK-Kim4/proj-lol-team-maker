package com.jw.teammaker.repository;

import com.jw.teammaker.domain.Player;
import com.jw.teammaker.presentation.dto.PlayerUpdateDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Service: PlayerRepository
 *
 * */
@Repository
@Transactional
public class PlayerRepository {

    @PersistenceContext
    private EntityManager em;

    /*플레이어 저장*/
    public Long save(Player player) {
        em.persist(player);
        return player.getId();
    }

    /*플레이어 삭제*/
    public void delete(Long playerId) {
        em.remove(findById(playerId));
    }
    
    /*플레이어 조회 - 고유번호*/
    public Player findById(Long playerId) {
        return em.find(Player.class, playerId);
    }

    /*플레이어 조회 - 이름*/
    public Player findByName(String playerName) {
        TypedQuery<Player> result = em.createQuery(
                        "select p " +
                                "from Player p " +
                                "where p.name = :name", Player.class)
                                .setParameter("name", playerName);
        return (Player) result;
    }

    /*플레이어 전체 조회*/
    public List<Player> findAll() {
        return em.createQuery("select p from  Player p", Player.class).getResultList();
    }

    public Long update(PlayerUpdateDto dto) {
        Player player = em.find(Player.class, dto.getPlayerId()).update(dto);
        return player.getId();
    }

    public int plusPlayerRating(Long playerId) {
        Player player = findById(playerId);
        player.setBadPlayerRating( (player.getBadPlayerRating()+1) );
        return player.getBadPlayerRating();
    }
}
