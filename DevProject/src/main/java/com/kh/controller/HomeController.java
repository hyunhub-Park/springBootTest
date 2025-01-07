package com.kh.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

// @Log
@Slf4j
@Controller
public class HomeController
{
//	// 멤버변수.
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@GetMapping(value = "/ajaxHome")
	public String ajaxHome ()
	{
		log.info("Headers Mapping Test...");
		
		return "ajaxHome";
	}
	
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