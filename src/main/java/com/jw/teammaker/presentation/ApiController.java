package com.jw.teammaker.presentation;

import com.jw.teammaker.domain.Team;
import com.jw.teammaker.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final PlayerService playerService;

    @GetMapping("/player/players")
    public ResponseEntity<Object> findAllPlayers(){
        return new ResponseEntity(playerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/player/get-teams")
    public ResponseEntity<Object> makeTeamsLogic(
            @RequestBody Long[] playerIds){
        List<Team> resultTeamList = playerService.makeTeams(playerIds);
        return new ResponseEntity<>(resultTeamList, HttpStatus.OK);
    }

}
