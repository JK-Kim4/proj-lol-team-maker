package com.jw.teammaker.service;

import com.jw.teammaker.common.util.CommonUtils;
import com.jw.teammaker.domain.Player;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import com.jw.teammaker.presentation.dto.PlayerUpdateDto;
import com.jw.teammaker.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service: PlayerService
 *
 * */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlayerService {

    private final Logger logger = LoggerFactory.getLogger(PlayerService.class);

    private final PlayerRepository playerRepository;

    /*PUBLIC*/

    /*플레이어 저장
    * Request Parameter: PlayerSaveDto dto
    * Response Parameter: Long PlayerId
    * */
    @Transactional
    public Long save(PlayerSaveDto dto){

        Player insertPlayer = Player.builder().saveDto(dto).build();
        return playerRepository.save(insertPlayer);
    }

    /*플레이어 삭제
    * Request Parameter: Long playerId
    * Response Parameter: void
    * */
    @Transactional
    public void delete(Long playerId){
        playerRepository.delete(playerId);
    }

    /*플레이어 수정 - 플레이어 정보
    * Request Parameter: Long playerId
    * Response Parameter: int result
    * */
    @Transactional
    public Long updatePlayer(PlayerUpdateDto dto){
        return playerRepository.update(dto);
    }


    /*플레이어 수정 - 신고 횟수 +
     * Request Parameter: Long playerId
     * Response Parameter: int result
     * */
    @Transactional
    public int plusBadPlayerRating(Long playerId){
        return playerRepository.plusPlayerRating(playerId);
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
    /*사용자 등록 여부 조회 - 이름*/
    private boolean isAlreadyExistPlayer(String playerName){
        return CommonUtils.isNull(playerRepository.findByName(playerName));
    }
}
