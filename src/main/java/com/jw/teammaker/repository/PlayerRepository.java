package com.jw.teammaker.repository;

import com.jw.teammaker.entity.Player;
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

    public Player findById(Long playerId) {
        return em.find(Player.class, playerId);
    }

    public void delete(Long playerId) {
        em.remove(findById(playerId));
    }

    public Player findByName(String playerName) {
        TypedQuery<Player> result = em.createQuery(
                        "select p " +
                                "from Player p " +
                                "where p.name = :name",
                                    Player.class)
                                .setParameter("name", playerName);
        return (Player) result;
    }

    public List<Player> findAll() {
        return em.createQuery("select p from  Player p", Player.class).getResultList();
    }
}
