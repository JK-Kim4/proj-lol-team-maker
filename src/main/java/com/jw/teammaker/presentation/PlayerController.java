package com.jw.teammaker.presentation;


import com.jw.teammaker.entity.Player;
import com.jw.teammaker.presentation.dto.PlayerSaveDto;
import com.jw.teammaker.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    private final PlayerService playerService;


    /*플레이어 리스트 페이지*/
    @GetMapping("/list")
    public String listPage(){
        return "player/list";
    }

    /*플레이어 등록 페이지*/
    @GetMapping("/save")
    public String savePage(){
        return "player/save";
    }

    /*플레이어 상세 페이지*/
    @GetMapping("/detail/{playerId}")
    public String detailPage(
            @PathVariable(name = "playerId") Long playerId,
            Model model){
        model.addAttribute("playerId", playerId);
        return "player/detail";
    }

    /*플레이어 조회 로직*/
    @GetMapping("/players")
    public ResponseEntity<Object> playerList(){
        List<Player> playerList = playerService.findAll();
        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }

    /*플레이어 등록 로직*/
    @PostMapping("/insert")
    public ResponseEntity<Object> playerInsertMethod(
            @RequestBody PlayerSaveDto dto){
        return new ResponseEntity<>(playerService.save(dto), HttpStatus.OK);
    }



}
