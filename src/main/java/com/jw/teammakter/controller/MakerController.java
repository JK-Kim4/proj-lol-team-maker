package com.jw.teammakter.controller;

import com.jw.teammakter.domain.PlayerInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MakerController {

    @GetMapping(value = {"/maker/index", "/"})
    public String indexPage(){
        return "index";
    }

    @GetMapping("/maker/player/insert")
    public String playerInsertPage(){
        return "playerInsert";
    }

    @GetMapping("/maker/making")
    public void teamMaking(PlayerInfo playerInfo){
        System.out.println("player name = " + playerInfo.getPlayerName());
    }

}
