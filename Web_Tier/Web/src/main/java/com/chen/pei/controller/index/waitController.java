package com.chen.pei.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Index")
public class waitController {

    @GetMapping("wait")
    public String Wait(){
        return "wait";
    }
}
