package com.chen.pei.controller.blog;

import com.chen.pei.entity.Blogger;
import com.chen.pei.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/ToLogin")
    public String ToLogin(@RequestParam("nickName") String nickName, @RequestParam("password") String password, Model model, HttpSession session){

        Blogger BlogLoginUser = loginService.findLogin(nickName,password);

//        if(BlogLoginUser != null){
//            //登录成功
//            model.addAttribute("loginUser",BlogLoginUser);
//            return "index";
//        }else{
//            //登录失败
//            model.addAttribute("msg","用户名或密码错误");
//            return "login";
//        }

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(nickName, password);

        try{
            //执行登录方法，如果没有异常证明ok
            subject.login(usernamePasswordToken);
            session.setAttribute("loginUser",BlogLoginUser);  //为了全部页面能使用到公共部分的loginUser.nickName
            return "blog/index";
        }catch(UnknownAccountException e){
            //用户名错误
            model.addAttribute("msg","用户名错误");
            return "blog/login";
        }catch(IncorrectCredentialsException e){
            //密码错误
            model.addAttribute("msg","密码错误");
            return "blog/login";
        }



    }


}
