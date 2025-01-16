package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeus.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController
{
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm()
	{
		log.info("loginForm (GET)");
		
		return "loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(String userId, String userPw, Model model)
	{
		log.info("login (POST)");
		
		log.info("login userId = " + userId);
		log.info("login userPw = " + userPw);
		
		Member member = new Member();
		
		member.setUserId(userId);
		member.setUserPw(userPw);
		member.setUserName("제우스");
		member.setEmail("zeus@zeus.com");
		
		model.addAttribute("user", member);
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(Member member, Model model)
//	{
//		log.info("login");
//		
//		log.info("login userId = " + member.getUserId());
//		log.info("login userPw = " + member.getUserPw());
//		
//		model.addAttribute("result", "로그인 되었습니다.");
//		return "success";
//	}
}