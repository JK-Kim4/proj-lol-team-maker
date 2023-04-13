package com.jw.teammaker;

import com.jw.teammaker.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class PlayerServiceTest {

    @Autowired
    PlayerService playerService;
}
