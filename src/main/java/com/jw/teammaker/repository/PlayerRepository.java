package com.jw.teammaker.repository;

import com.jw.teammaker.entity.Player;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Service: PlayerRepository
 *
 * */
@Repository
public class PlayerRepository {

    @PersistenceContext
    private EntityManager em;

    /*플레이어 저장*/
    public Long save(Player player) {
        em.persist(player);
        return player.getId();
    }

    public Player findById(Long playerId) {
        return em.find(Player.class, playerId);
    }

    public void delete(Player findPlayer) {
        em.remove(findPlayer);
    }

    public Player findByName(String playerName) {
        TypedQuery<Player> result = em.createQuery(
                        "select p " +
                                "from Player p " +
                                "where name = :name",
                                    Player.class)
                                .setParameter("name", playerName);
        return (Player) result;
    }

    public List<Player> findAll() {
        return em.createQuery("select p from  Player p", Player.class).getResultList();
    }
}
