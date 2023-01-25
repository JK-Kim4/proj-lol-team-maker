package com.jw.teammakter.controller;

import com.jw.teammakter.domain.Player;
import com.jw.teammakter.domain.PlayerOnTeam;
import com.jw.teammakter.service.MakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    public String playerInsertPage(){
        return "playerInsert";
    }

    @PostMapping("/maker/making")
    @ResponseBody
    public int teamMaking(@RequestBody ArrayList<Player> info){
        System.out.println("player name = " + info.size());

        List<PlayerOnTeam> result = makerService.makeTeam(info);

        return info.size();
    }

}
