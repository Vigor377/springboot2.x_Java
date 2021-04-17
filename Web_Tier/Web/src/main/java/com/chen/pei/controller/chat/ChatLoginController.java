package com.chen.pei.controller.chat;

import com.chen.pei.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class ChatLoginController {
    @PostMapping("/toLogin")
    public Result toLogin(String user, String pwd, HttpSession httpSession){
        Result result = new Result();
        httpSession.setMaxInactiveInterval(30*60);
        log.info(user+"登录验证中..");
        if(httpSession.getAttribute("user") != null){
            result.setFlag(false);
            result.setMessage("不支持一个浏览器登录多个用户！");
            return result;
        }
        if (user.equals("张三")&&pwd.equals("123")){
            result.setFlag(true);
            log.info(user+"登录验证成功");
            httpSession.setAttribute("user",user);
        }else if (user.equals("李四")&&pwd.equals("123")){
            result.setFlag(true);
            log.info(user+"登录验证成功");
            httpSession.setAttribute("user",user);
        }else if (user.equals("田七")&&pwd.equals("123")){
            result.setFlag(true);
            log.info(user+"登录验证成功");
            httpSession.setAttribute("user",user);
        }
        else if (user.equals("王五")&&pwd.equals("123")){
            result.setFlag(true);
            log.info(user+"登录验证成功");
            httpSession.setAttribute("user",user);
        }else {
            result.setFlag(false);
            log.info(user+"验证失败");
            result.setMessage("登录失败");
        }
        return result;
    }
    @RequestMapping("/getUsername")
    public String getUsername(HttpSession httpSession){
        String username = (String) httpSession.getAttribute("user");
        return username;
    }
}
