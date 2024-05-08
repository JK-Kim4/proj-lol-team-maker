package com.jw.teammaker.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping(value = {"/", "/index"})
    public String indexPage(){
        return "index";
    }

    @GetMapping("/sockect/index")
    public String wsIndex(){
        return "/web-socket-index";
    }
}
