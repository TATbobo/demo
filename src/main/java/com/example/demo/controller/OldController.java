package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

//@Controller
public class OldController {

    @GetMapping(value ="/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){

        if(username!=null) {
            if (!StringUtils.isEmpty(username) && "1".equals(password)) {
                //登陆成功
                session.setAttribute("loginUser", username);
            }
            return "dashboard";
        }
        else {
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
    @GetMapping(value = "/user/login")
    public String login(){
        return "login";

    }
}
