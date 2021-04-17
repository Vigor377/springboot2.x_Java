package com.chen.pei.controller.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/Index")
public class PageController {

    @RequestMapping("/chat")
    public String login(){
        return "chat/login";
    }

    @RequestMapping("/main")
    public String main(){
        return "chat/main";
    }

    @RequestMapping("/loginerror")
    public String loginError(){
        return "chat/loginerror";
    }

}
