package com.jw.teammaker.service;

import com.jw.teammaker.common.CommonValue;
import com.jw.teammaker.common.util.CommonUtils;
import com.jw.teammaker.domain.Player;
import com.jw.teammaker.domain.Team;
import com.jw.teammaker.exception.NotEnoughPlayerException;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import com.jw.teammaker.presentation.dto.PlayerUpdateDto;
import com.jw.teammaker.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public int addBadPlayerRating(Long playerId){
        return playerRepository.plusPlayerRating(playerId);
    }

    public List<Team> makeTeams(Long[] playerIds, String type) {
        List<Team> resultList = new ArrayList<>();

        //플레이어 수 검증 (10명)
        if(playerIds.length != 10){
            throw new NotEnoughPlayerException("플레이어 수가 부족합니다. Player length: " +playerIds.length);
        }

        //플레이어 조회
        List<Player> playerList =  Arrays
                .stream(playerIds)
                .map(id -> playerRepository.findById(id))
                .sorted(Comparator.comparing(Player::getEvaluationPoint))
                .collect(Collectors.toList());

        if(CommonValue.MAKE_TEAM_LOGIC_BALANCE.equals(type)){

        }else if(CommonValue.MAKE_TEAM_LOGIC_RANDOM.equals(type)){

        }else{
            resultList = makeTeamsDefaultLogic(playerList);
        }

        return resultList;
    }


    /*팀 생성 로직 - 기본*/
    private List<Team> makeTeamsDefaultLogic(List<Player> playerList) {

        //변수 초기화
        Team teamA = new Team();
        Team teamB = new Team();
        List<Team> resultList = new ArrayList<>();

        /*팀 분배
        * Team A: [ 1,3,5,8,10 ]
        * Team B: [ 2,4,6,7,9  ]
        * */
        int[] teamAIndex = {0,2,4,7,9};
        int[] teamBIndex = {1,3,5,6,8};

        for(int i: teamAIndex){
            teamA.addPlayer(playerList.get(i));
            teamA.sumTotalPoint(playerList.get(i).getEvaluationPoint());

        }

        for(int i: teamBIndex){
            teamB.addPlayer(playerList.get(i));
            teamB.sumTotalPoint(playerList.get(i).getEvaluationPoint());
        }

        resultList.add(teamA);
        resultList.add(teamB);

        return resultList;
    }

    private List<Team> makeTeamRandomLogic(List<Player> playerList) {
        //변수 초기화
        Team teamA = new Team();
        Team teamB = new Team();
        List<Team> resultList = new ArrayList<>();
        boolean teamFlag = false;




        return resultList;
    }

    private List<Team> makeTeamBalanceLogic(List<Player> playerList) {
        //변수 초기화
        Team teamA = new Team();
        Team teamB = new Team();
        List<Team> resultList = new ArrayList<>();


        return resultList;
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
