package com.smhrd.bridge.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.smhrd.bridge.entity.UserInfo;
import com.smhrd.bridge.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;

	@PostMapping("/user/register")
	public String register(UserInfo user) {
		try {
			service.register(user);
			System.out.println("회원가입 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 실패");
		}
		return "redirect:/";
	}

	@PostMapping("/user/login")
	public String login(UserInfo user, HttpSession session) {
	    UserInfo result = service.login(user);

	    if (result == null) {
	        System.out.println("로그인 실패");
	    } else {
	        session.setAttribute("loginUser", result);
	        System.out.println("로그인 성공");
	    }
	    return "redirect:/";
	}

}
