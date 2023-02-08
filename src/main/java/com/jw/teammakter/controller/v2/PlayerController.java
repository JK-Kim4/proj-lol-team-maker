package com.jw.teammakter.controller.v2;

import com.jw.teammakter.domain.v1.PlayerOnTeam;
import com.jw.teammakter.domain.v2.PlayerV2;
import com.jw.teammakter.service.v2.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v2/player")
@Slf4j
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/list")
    public String listPage(Model model) throws Exception{
        List<PlayerV2> playerV2List = playerService.getPlayerList();
        if(playerV2List != null && playerV2List.size() > 0){
            model.addAttribute("players", playerV2List);
        }
        return "player2/playerList";
    }

    @GetMapping("/insert")
    public String insertPage(){
        return "player2/playerInsert";
    }

    @PostMapping("/insert")
    @ResponseBody
    public int insertMethod(@RequestBody PlayerV2 playerV2){
        return playerService.insertPlayerV2(playerV2);
    }

    @PostMapping("/make/team")
    @ResponseBody
    public List<PlayerOnTeam> teamMaking(Model model, @RequestBody List<Integer> info){


        return null;
    }

}
