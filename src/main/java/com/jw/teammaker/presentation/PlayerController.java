package com.jw.teammaker.presentation;


import com.jw.teammaker.service.PlayerService;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    private final PlayerService playerService;

    private PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

}
