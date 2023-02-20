package com.jw.teammakter.v2;

import com.jw.teammakter.domain.Position;
import com.jw.teammakter.domain.Tier;
import com.jw.teammakter.domain.v2.PlayerV2;
import com.jw.teammakter.domain.v2.PositionGroup;
import com.jw.teammakter.service.v2.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("dev")
public class PlayerServiceTest {

    @Autowired
    PlayerService playerService;


    @Test
    public void 팀_생성_테스트(){
        //given - 10 players(V2)

        List<PlayerV2> playerV2List = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            PlayerV2 temp = new PlayerV2();
            int validator = (int) (Math.random()*10);

            System.out.println("validatior = " + validator);

            temp.setId(i);
            temp.setPlayerName("player"+(i+1));

            switch (validator){
                case 1:
                    temp.setPositionMain(Position.ADCARRY.name());
                    temp.setPositionSub(Position.SUPPORTER.name());
                    temp.setTier(Tier.SILVER.name());
                    break;
                case 2:
                    temp.setPositionMain(Position.ADCARRY.name());
                    temp.setPositionSub(Position.JUNGLE.name());
                    temp.setTier(Tier.SILVER.name());
                    break;
                case 3:
                    temp.setPositionMain(Position.JUNGLE.name());
                    temp.setPositionSub(Position.TOP.name());
                    temp.setTier(Tier.SILVER.name());
                    break;
                case 4:
                    temp.setPositionMain(Position.TOP.name());
                    temp.setPositionSub(Position.SUPPORTER.name());
                    temp.setTier(Tier.SILVER.name());
                    break;
                case 5:
                    temp.setPositionMain(Position.APCARRY.name());
                    temp.setPositionSub(Position.JUNGLE.name());
                    temp.setTier(Tier.GOLD2.name());
                    break;
                default:
                    temp.setPositionMain(Position.SUPPORTER.name());
                    temp.setPositionSub(Position.JUNGLE.name());
                    temp.setTier(Tier.GOLD2.name());
                    break;
            }
            playerV2List.add(temp);
        }


        playerV2List.stream().forEach(playerV2 -> {
            System.out.println("name = " +playerV2.getPlayerName() +", main = " +playerV2.getPositionMain());
        });

        //when - make Teams
        List<PositionGroup> positionGroupList = playerService.separateWithPosition(playerV2List);

        positionGroupList.stream().forEach(pg->{
            System.out.println("=======" + pg.getPositionName() + " POSITION PLAYER =======");
            pg.getPlayerOnPosition().stream().forEach(playerV2 -> {
                System.out.println("name = " +playerV2.getPlayerName() + ", main position = "+playerV2.getPositionMain() +", sub position = "+playerV2.getPositionSub());
            });
        });

        //then - validation Teams
    }

    @Test
    public void 포지션_스트림_테스트(){
        Position.stream().forEach(position -> {
            System.out.println("position = " + position.name());
        });
    }
}
