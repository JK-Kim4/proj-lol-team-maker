package com.jw.teammaker.service;

import com.jw.teammaker.common.util.CommonUtils;
import com.jw.teammaker.entity.Player;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import com.jw.teammaker.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service: PlayerService
 *
 * */
@Service
@RequiredArgsConstructor
public class PlayerService {

    private final Logger logger = LoggerFactory.getLogger(PlayerService.class);

    private final PlayerRepository playerRepository;

    /*PUBLIC*/

    /*플레이어 저장
    * Request Parameter: PlayerSaveDto dto
    * Response Parameter: Long PlayerId
    * */
    public Long save(PlayerSaveDto dto){
        return playerRepository.save(new Player(dto));
    }
    /*플레이어 삭제
    * Request Parameter: Long playerId
    * Response Parameter: void
    * */
    public void delete(Long playerId){
        playerRepository.delete(playerId);
    }

    /*플레이어 조회
    * Request Parameter: Long playerId
    * Response Parameter: Player findPlayer
    * */
    public Player findById(Long playerId){
        return playerRepository.findById(playerId);
    }

    /*플레이어 전체 조회*/
    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    /*private*/
    private boolean isAlreadyExistPlayer(String playerName){
        return CommonUtils.isNull(playerRepository.findByName(playerName));
    }
}
