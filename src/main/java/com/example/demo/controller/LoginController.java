package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@Autowired
	UserMapper userMapper;
	/*欢迎页*/
	@GetMapping("/")
	public String index() {
		return "dashboard";
	}
	
    /*登陆页*/
	@GetMapping("/user/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/user/register")
	public String registerPage(){return "register";}

	@PostMapping("/user/register")
	public String registerUser(User user){

		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword().trim()));
		System.out.println(user);
		userMapper.insertUser(user);
		return "redirect:/user/login";
	}

}
