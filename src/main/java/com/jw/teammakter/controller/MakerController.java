package com.jw.teammakter.controller;

import com.jw.teammakter.Application;
import com.jw.teammakter.domain.Player;
import com.jw.teammakter.domain.PlayerOnTeam;
import com.jw.teammakter.service.MakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MakerController {

    private MakerService makerService;

    @Autowired
    public MakerController(MakerService makerService){
        this.makerService = makerService;
    }

    @GetMapping(value = {"/maker/index", "/"})
    public String indexPage(){
        return "index";
    }

    @GetMapping("/maker/player/insert")
    public String playerInsertPage(Model model){
        model.addAttribute("players", Application.PLAYER);
        return "playerInsert";
    }

    @PostMapping("/maker/making")
    @ResponseBody
    public List<PlayerOnTeam> teamMaking(@RequestBody List<Player> info){
        info.forEach(player -> {
            System.out.println("input playername = " +player.getPlayerName());
        });

        List<PlayerOnTeam> result = makerService.makeTeam(info);

        System.out.println(result.get(0).getTeam());
        System.out.println(result.get(1).getTeam());


        return result;
    }

    @GetMapping("/template")
    public String templatePage(){
        return "starter-template";
    }
}
