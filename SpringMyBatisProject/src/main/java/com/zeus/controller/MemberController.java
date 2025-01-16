package com.zeus.controller;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeus.domain.Member;
import com.zeus.service.MemberService;

import lombok.extern.java.Log;


@Log
@Controller
@RequestMapping("/user")
@MapperScan(basePackages = "com.zeus.mapper")
public class MemberController
{
	@Autowired
	private MemberService service;

	/* [단일] 검색기능 추가. */
//	@RequestMapping(value = "/search", method = RequestMethod.POST)
//	public String search(String userId, Model model) throws Exception
//	{
//		log.info("search");
//		
//		Member member = new Member();
//		
//		member.setUserId(userId);
//
//		model.addAttribute("member", member);
//		model.addAttribute("list", service.search(userId));
//		
//		return "user/list";
//	}
	
	/* [다중] 검색기능 추가.*/
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(String searchKeyword, Model model) throws Exception
	{
		log.info("search");

		// searchKeyword로 userId와 userName을 모두 검색.
		List <Member> memberList = service.search(searchKeyword);

		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("list", memberList);

		return "user/list";
	}
	
	// 사용자 입력 폼 요청. (/WEB-INF/views/user/register.jsp)
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerForm(Member member, Model model) throws Exception
	{
		log.info("UserRegisterForm");
	}
	
	// 사용자 입력 내용 DB등록 및 저장. (/WEB-INF/views/user/seccess.jsp)
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member, Model model) throws Exception
	{
		service.register(member);
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		
		return "user/success";
	}
	
	// 가입 회원 목록 조회. (사용자 정보 리스트) (/WEB-INF/views/user/list.jsp)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception
	{	// http://localhost:8080/user/list
		log.info("list");
		
		model.addAttribute("member", new Member());
		model.addAttribute("list", service.list());
	}
	
	// 사용자 정보의 상세내역 요청. (/WEB-INF/views/user/read.jsp)
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(int userNo, Model model) throws Exception
	{
		model.addAttribute(service.read(userNo));
	}
	
	// 사용자 수정 폼 요청. (/WEB-INF/views/user/modify.jsp)
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(int userNo, Model model) throws Exception
	{
		model.addAttribute(service.read(userNo));
	}

	// 사용자 수정 내역 DB에 전달. (/WEB-INF/views/user/sueccess.jsp)
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Member member, Model model) throws Exception
	{
		service.modify(member);
		
		model.addAttribute("msg", "수정이 완료되었습니다.");
		
		return "user/success";
	}

	// 사용자 삭제 요청. (/WEB-INF/views/user/success.jsp)
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(int userNo, Model model) throws Exception
	{
		service.remove(userNo);
		
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		
		return "user/success";
	}

}