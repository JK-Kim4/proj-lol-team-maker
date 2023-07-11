package com.jw.teammaker.presentation;

import com.jw.teammaker.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final PlayerService playerService;

    @GetMapping("/player/players")
    public ResponseEntity<Object> findAllPlayers(){
        return new ResponseEntity(playerService.findAll(), HttpStatus.OK);
    }

}
