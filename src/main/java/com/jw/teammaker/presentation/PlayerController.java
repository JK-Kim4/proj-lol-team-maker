package com.jw.teammaker.presentation;


import com.jw.teammaker.entity.Player;
import com.jw.teammaker.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    private final PlayerService playerService;

    @GetMapping("/player")
    public ResponseEntity<Object> playerList(){
        List<Player> playerList = playerService.findAll();
        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }



}
