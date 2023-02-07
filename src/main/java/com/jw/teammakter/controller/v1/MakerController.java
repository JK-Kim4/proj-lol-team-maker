package com.jw.teammakter.controller.v1;

import com.jw.teammakter.domain.v1.Player;
import com.jw.teammakter.domain.v1.PlayerOnTeam;
import com.jw.teammakter.domain.v2.PlayerV2;
import com.jw.teammakter.service.v1.MakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/maker/player/list")
    public String playerListPage(Model model){
        model.addAttribute("players", makerService.getPlayerAll());
        return "player/playerList";
    }

    @GetMapping("/maker/player/insert")
    public String playerInsertPage(){
        return "player/playerInsert";
    }

    @GetMapping("/maker/players")
    @ResponseBody
    public List<Player> getPlayerAll(){
        return makerService.getPlayerAll();
    }

    @PostMapping("/maker/player/insert")
    @ResponseBody
    public Player insertMethod(@RequestBody Player player){
        return makerService.insertPlayer(player);
    }

    @PostMapping("/maker/making")
    @ResponseBody
    public List<PlayerOnTeam> teamMaking(Model model, @RequestBody List<Integer> info){
        List<Player> selectedPlayer = makerService.getPlayersById(info);
        List<PlayerOnTeam> result = makerService.makeTeam(selectedPlayer);
        return result;
    }

    @DeleteMapping("/maker/delete/{id}")
    @ResponseBody
    public void deleteMethod(@PathVariable("id") int id){
        makerService.deletePlayer(id);
    }

    @GetMapping("/template")
    public String templatePage(){
        return "starter-template";
    }

    @GetMapping("/maker/v2/player/list")
    public String listPage(Model model){

        return "player2/playerList";
    }

    @GetMapping("/maker/v2/player/insert")
    public String insertPage(){
        return "player2/playerInsert";

    }

    @PostMapping("/maker/v2/player/insert")
    @ResponseBody
    public PlayerV2 insertMethod(@RequestBody PlayerV2 playerV2){
        return makerService.insertPlayerV2(playerV2);

    }
}
