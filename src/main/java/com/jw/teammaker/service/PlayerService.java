package com.jw.teammaker.service;

import com.jw.teammaker.common.util.CommonUtils;
import com.jw.teammaker.entity.Player;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import com.jw.teammaker.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service: PlayerService
 *
 * */
@Service
public class PlayerService {

    private final Logger logger = LoggerFactory.getLogger(PlayerService.class);

    private PlayerRepository playerRepository;

    private PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }


    /*PUBLIC*/

    /*플레이어 저장
    * Request Parameter: PlayerSaveDto dto
    * Response Parameter: Long PlayerId
    * */
    public Long save(PlayerSaveDto dto){
        if(!isAlreadyExistPlayer(dto.getName())){
            return playerRepository.save(Player.builder()
                                            .dto(dto)
                                        .build());
        }else {
            throw new IllegalArgumentException("이미 존재하는 플레이어 이름입니다.");
        }
    }
    /*플레이어 삭제
    * Request Parameter: Long playerId
    * Response Parameter: void
    * */
    public void delete(Long playerId){
        Player findPlayer = playerRepository.findById(playerId);
        if(!CommonUtils.isNull(findPlayer)){
            playerRepository.delete(findPlayer);
        }else {
            throw new IllegalArgumentException("삭제할 사용자의 ID를 확인해 주세요.");
        }
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
