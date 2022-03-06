package com.example.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping({"/", "/index"})
    public String index(Model model){
        model.addAttribute("msg","hello shiro");
        return "index";
    }
    @RequestMapping("user/add")
    public String add(Model model){
        return "user/add";
    }
    @RequestMapping("user/edit")
    public String edit(Model model){
        return "user/edit";
    }

    @RequestMapping("toLogin")
    public String toLogin(Model model){
        return "login";
    }

    @RequestMapping("login")
    public String login(String name, String password, Model model){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken userToken = new UsernamePasswordToken(name, password);
        try{
            subject.login(userToken);
            return "index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码不正确");
            return "login";
        }
    }
}
