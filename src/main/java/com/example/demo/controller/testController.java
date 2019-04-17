package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@Controller
public class testController {
    /*@RequestMapping({"/","/index.html"})
    public String test(){
        return "index";
    }
*/
    @RequestMapping("/user")
    public String userMap(Map<String,Object> map){
        map.put("test","<h4>use thymeleaf<h4/>");
        map.put("user", Arrays.asList("猩猩","波波" ));
        return "login";
    }
}
