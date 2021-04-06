package com.chen.pei.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    /**
     * 404页面
     */
    @GetMapping(value = "/404")
    public String error_404() {
        return "404";
    }

    /**
     * 500页面
     */
    @GetMapping(value = "/500")
    public String error_500() {
        return "500";
    }

    /**
     * 405页面
     */
    @GetMapping(value = "/405")
    public String error_405() {
        return "405";
    }
}
