package com.kh.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.domain.Board;

import lombok.extern.slf4j.Slf4j;

// @Log
@Slf4j
@Controller
public class HomeController
{
//	// 멤버변수.
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	 @RequestMapping(value = "/memberInsert", method = RequestMethod.GET) 
	 public	 String memberInsert()
	 {
		 return "memberInsert";
	 }
	 
	 @RequestMapping(value = "/ajaxHome5", method = RequestMethod.GET) 
	 public	 String ajaxHome5()
	 {
		 return "ajaxHome5";
	 }
	 
	 @RequestMapping(value = "/ajaxHome6", method = RequestMethod.GET) 
	 public	 String ajaxHome6()
	 {
		 return "ajaxHome6";
	 }
	 
	 @RequestMapping(value = "/registerFileUpForm", method = RequestMethod.GET) 
	 public String registerFileUpForm ()
	 {
		 log.info("registerFileUpForm");
		 return "registerFileUpForm";
	 }
	 
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	 public String home(Locale locale, Model model)
	 {
		 log.info("환영합니다. 클라이언트 지역은 " + locale + "이다.");
		 
		 LocalDateTime now = LocalDateTime.now();
		 
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E) a h시 m분 s초");
		 
		 String formattedNow = now.format(formatter);
		 
		 model.addAttribute("serverTime", formattedNow);
		 
		 return "home";
	 }
	
//	
//	@ResponseBody
//	@GetMapping(value = "/gohome10")
//	public Map<String, Board> gohome10()
//	{
//		log.info("컬렉션 Map 타입 home08");
//		Map<String, Board> map = new HashMap() <String, Baord>();
//		Board board = new Baord();
//		
//		board.setTitle("제목"); 
//		board.setContent("내용입니다."); 
//		board.setWriter("홍길동"); 
//		board.setRegDate(new Date());
//		map.put("key1", board);
//
//		Board board2 = new Board();
//		board2.setTitle("제목2"); 
//		board2.setContent("내용입니다.2"); 
//		board2.setWriter("홍길동2"); 
//		board2.setRegDate(new Date());
//		map.put("key2", board2);
//		return map;
//	}
//	
	
//	@RequestMapping(value = "/ajaxHome", method = RequestMethod.GET) 
//	public String ajaxHome() {
//	log.info("Content Type 매핑"); 
//	//return "ajaxHome";
//	return "ajaxHome";
//	}
	
//	@GetMapping(value = "/ajaxHome2") 
//	public String ajaxHome2() {
//	log.info("ajaxHome2"); 
//	return "ajaxHome2";
//	}
//	
//	@GetMapping(value = "/ajaxHome3") 
//	public String ajaxHome3() {
//	log.info("ajaxHome3"); 
//	return "ajaxHome3";
//	}
	
//	@GetMapping(value = "/gohome01") 
//	public String gohome01()
//	{	// 05-5p
//		log.info("redirect: /gohome02"); 
//		return "redirect:/gohome02";
//	}
//	
//	@GetMapping(value = "/gohome02") 
//	public String gohome02()
//	{
//		log.info("/gohome02"); 
//		return "home";
//	}
	
//	@GetMapping(value = "/ajaxHome")
//	public String ajaxHome ()
//	{
//		log.info("Headers Mapping Test...");
//		
//		return "ajaxHome";
//	}
	
//	public String home (Locale locale, Model model)
//	{
//		@GetMapping(value="/ajaxhome")
//		public String ajaxhome()
//		{
//			
//			return "ajaxhome";
//		}
//		
//	}
	
// 1번, 2번 과제.	
//	@GetMapping(value = "/formHome") 
//	public String formHome() {
//	log.info("GET 방식 formHome");
//	return "formHome";
//	}		
		
//	@RequestMapping(value="/", method = RequestMethod.GET)
//	// @RequestMapping -> 5가지를 받음. delete, get, patch, post, put
//	public String home (Locale locale, Model model)
//	{
//		// info 레벨의 로그를 출력한다.
//		
//		// locale, model에 객체 주입된 것을 활용해 출력.
//		Date date = new Date();
//		
//		// singleton.
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formatterDate = dateFormat.format(date);
//		
//		model.addAttribute("작업시간", formatterDate);
//		logger.info("logger 작업시간" + model);
//		
////		log.info("환영합니다. 지역은 " + locale + ".");
////		log.info("model.toString() : " + model.toString());
//		System.out.println("model 객체 : " + model);
//
//		System.out.println(model);

		
//		// Spring Boot가 모두 전달해 주므로 Model m = new Model()만들 필요 없음.
//		System.out.println("sysout print" + locale);
//		log.info("log print" + locale);
		//return "home";	// /WEB-INF/views/home.jsp
}