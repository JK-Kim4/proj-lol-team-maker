package com.jw.teammakter.controller.v2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexV2Controller {

    @GetMapping({"/v2","/v2/index"})
    public String indexV2(){
        return "index-v2";
    }


}
