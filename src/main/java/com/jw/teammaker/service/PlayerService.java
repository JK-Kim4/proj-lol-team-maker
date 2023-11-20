package com.jw.teammaker.service;

import com.jw.teammaker.common.CommonValue;
import com.jw.teammaker.common.util.CommonUtils;
import com.jw.teammaker.common.util.DuoComparator;
import com.jw.teammaker.common.util.PlayerComparator;
import com.jw.teammaker.domain.Duo;
import com.jw.teammaker.domain.Player;
import com.jw.teammaker.domain.Team;
import com.jw.teammaker.exception.DuoIndexOutOfBoundsException;
import com.jw.teammaker.exception.NotEnoughPlayerException;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import com.jw.teammaker.presentation.dto.TeamResponseDto;
import com.jw.teammaker.presentation.dto.PlayerUpdateDto;
import com.jw.teammaker.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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

    public List<Player> findPlayerListByIds(Long[] ids){
        return playerRepository.findPlayerListByIds(ids);
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
                .collect(Collectors.toList());

        if(CommonValue.MAKE_TEAM_LOGIC_BALANCE.equals(type)){
            resultList = makeTeamDefaultLogic(playerList);
        }else if(CommonValue.MAKE_TEAM_LOGIC_RANDOM.equals(type)){
            resultList = makeTeamRandomLogic(playerList);
        }else{
            resultList = makeTeamDefaultLogic(playerList);
        }

        return resultList;
    }

    public List<Team> makeTeamsWithDuo(List<Long[]> duoIdList, Long[] playerIds, String type){
        List<Team> resultList = new ArrayList<>();
        List<Duo> duoList = new ArrayList<>();

        //0. 듀오 슬롯이 빈 값으로 넘어올 경우: 일반 팀 분배 로직 call
        if(duoIdList == null && duoIdList.size() == 0){
            return this.makeTeams(playerIds, type);
        }
        //1. duoSlot 최대값 검증
        if(duoIdList.size() > 4) {
            throw new DuoIndexOutOfBoundsException("듀오는 최대 8인(4개)까지 가능합니다.");
        }
        //2. 듀오 슬롯 선수 조회
        for(Long[] duoSlot: duoIdList){
            Duo duo = new Duo();
            for(Long id: duoSlot){
                duo.addPlayer(playerRepository.findById(id));
            }
            duoList.add(duo);
        }

        List<Player> playerList =  Arrays
                .stream(playerIds)
                .map(id -> playerRepository.findById(id))
                .collect(Collectors.toList());

        resultList = makeTeamWithDuoLogic(duoList, playerList);

        return resultList;
    }

    /* TODO
    *  팀 분배 기본 로직 수정
    *  기존: 평가점수 내림차수 정렬 후 List Index 기준 팀 분배
    *  수정: minimax(team-maker-algo.md 참조) 팀 분배*/
    /*팀 생성 로직 - 기본*/
    private List<Team> makeTeamDefaultLogic(List<Player> playerList) {

        //변수 초기화
        Team teamA = new Team();
        Team teamB = new Team();
        List<Team> resultList = new ArrayList<>();
        Collections.sort(playerList, new PlayerComparator());

        /*팀 분배(기존)
        * Team A: [ 1,3,5,8,10 ]
        * Team B: [ 2,4,6,7,9  ]
        * */
        for(int i = 0; i < 5; i++){
            if(i == 4){
                teamB.addPlayer(playerList.remove(playerList.size() -1));
                teamA.addPlayer(playerList.remove(0));
            }else{
                if(i % 2 == 0){
                    teamA.addPlayer(playerList.remove(playerList.size() -1));
                    teamA.addPlayer(playerList.remove(0));
                }else{
                    teamB.addPlayer(playerList.remove(playerList.size() -1));
                    teamB.addPlayer(playerList.remove(0));
                }
            }
        }

        /*팀 분배(minimax)*/
        //01. 평가점수 최상위 플레이어 2명 팀 분배 (1:TeamA / 2:TeamB)
        /*teamA.addPlayer(playerList.remove(0));
        teamA.addPlayer(playerList.remove(playerList.size()-1));
        teamB.addPlayer(playerList.remove(0));
        teamB.addPlayer(playerList.remove(playerList.size()-1));
        //02. (loop) playerList 포함 된 플레이어 중 팀 평균 점수와 가장 차이가 있는 플레이어를 선별하여 해당 팀에 편입
        for(int i = 0; i < 6; i++){
            if(i % 2 == 0){
                teamB.addPlayer(playerList.remove(0));
            }else{
                teamA.addPlayer(playerList.remove(0));
            }
        }*/

        resultList.add(teamA);
        resultList.add(teamB);

        return resultList;
    }

    private List<Team> makeTeamRandomLogic(List<Player> playerList) {
        //변수 초기화
        Team teamA = new Team();
        Team teamB = new Team();
        List<Team> resultList = new ArrayList<>();
        //플레이어 Shuffle
        Collections.shuffle(playerList);

        //팀 분배
        for(int i = 0; i < playerList.size(); i++){
            if(i % 2 == 0) teamA.addPlayer(playerList.get(i));
            else teamB.addPlayer(playerList.get(i));
        }
        resultList.add(teamA);
        resultList.add(teamB);
        return resultList;
    }

    private List<Team> makeTeamBalanceLogic(List<Player> playerList) {
        //변수 초기화
        Team teamA = new Team();
        Team teamB = new Team();
        List<Team> resultList = new ArrayList<>();


        return resultList;
    }

    private List<Team> makeTeamWithDuoLogic(List<Duo> duoList, List<Player> playerList){
        //변수 초기화
        Team teamA = new Team();
        Team teamB = new Team();
        List<Team> resultList = new ArrayList<>();

        float totalRating = 0.0f;
        float averageRating = 0.0f;
        for(Duo d: duoList){
            totalRating += d.getDuoTotalPoint();
        }
        for(Player p: playerList){
            totalRating += p.getEvaluationPoint();
        }
        averageRating = totalRating / 10.f;


        //듀오 큐 수가 홀수인 경우 -> 1개의 추가 듀오 생성
        if(duoList.size() % 2 != 0){
            float tempAverageRate = 0.00f;
            for(Duo duo: duoList){
                tempAverageRate += duo.getDuoAveragePoint();
            }
            tempAverageRate = tempAverageRate/(float) duoList.size();
            duoList.add(makeDuoNearAverageRate(playerList, tempAverageRate));
        }


        resultList.add(teamA);
        resultList.add(teamB);

        return resultList;
    }

    private Duo makeDuoNearAverageRate(List<Player> playerList, float tempAverageRate) {
        Duo result = new Duo();
        Player player1 = new Player();
        Player player2 = new Player();
        float comparisonValue = 9999.99f;

        for(Player p1: playerList){
            for(Player p2: playerList){
                if(p1 == p2) continue;
                float playerAverageRate = ( p1.getEvaluationPoint() + p2.getEvaluationPoint() ) / 2.0f;

                if(Math.abs(playerAverageRate - tempAverageRate) < comparisonValue){
                    comparisonValue = Math.abs(playerAverageRate - tempAverageRate);
                    player1 = p1;
                    player2 = p2;
                }else {
                    continue;
                }
            }
        }

        playerList.remove(player1);
        playerList.remove(player2);
        result.addPlayer(player1);
        result.addPlayer(player2);
        return result;
    }

    /*private*/
    /*사용자 등록 여부 조회 - 이름*/
    private boolean isAlreadyExistPlayer(String playerName){
        return CommonUtils.isNull(playerRepository.findByName(playerName));
    }

    private TeamResponseDto assignPlayerToTeam(){
        return null;
    }

}
