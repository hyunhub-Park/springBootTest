package com.kh.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.domain.Member;

import lombok.extern.slf4j.Slf4j;

// @Log
@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController
{

	@PostMapping (value = "/insert")
	public String insertMember (Member member, @DateTimeFormat(pattern = "yyyyMMdd") Date dateOfBirth/*,Model model, int coin, Date dateOfBirth*/)
	{
		log.info("insertMember");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("member.getCoin() = " + member.getCoin());
		// log.info("coin = " + coin);
		// log.info("date of birth = " + dateOfBirth);
		log.info("member.getDateOfBirth = " + member.getDateOfBirth());
		log.info("member.yyyyMMdd = " + dateOfBirth);

		return "home";
	}
}