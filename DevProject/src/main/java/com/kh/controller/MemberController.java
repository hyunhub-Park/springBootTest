package com.kh.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.domain.FileMember;
import com.kh.domain.Member;

import lombok.extern.slf4j.Slf4j;

// @Log
@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController
{
	
	@PostMapping(value = "/redirect")
	public String redirectMember (Member member, RedirectAttributes rttr)
	{	// 07-35p.
		log.info("redirectMember");
		rttr.addFlashAttribute("member", member);
		
		return "redirect:/member/result";
	}
	
	// url을 받은 것이기 때문에, getMapping.
	@GetMapping(value = "/result")
	// @RequestMapping(value = "/result"), 아래의 Member매개변수는 안해도 됨.
	public String redirectResult (Member member)
	{	// 07-35p.
		log.info("redirectReseult");
		
		return "result";
	}
	
	
	@PostMapping(value = "/insert")
	public String insertMember (@ModelAttribute("userId") String userId, @ModelAttribute("password") String password, Model model)
	{	// 07-30p의 방법 3가지.
		log.info("insertMember");
		
		
//		model.addAttribute("userId", userId);
//		model.addAttribute("password", password);
		
		return "home";
	}
	
	
	@RequestMapping(value = "/registerFileUp01", method = RequestMethod.POST) 
	public String registerFileUp01(FileMember filemember/*@RequestBody List <MultipartFile> picture, @RequestBody MultipartFile picture1, @RequestBody MultipartFile picture2*/) throws Exception
	{
		if (!filemember.getPicture().isEmpty())
		{
			for (MultipartFile data : filemember.getPicture())
			{
				log.info("registerFileUp");
				log.info("originalName: " + data.getOriginalFilename()); 
				log.info("size: " + data.getSize()); 
				log.info("contentType: " + data.getContentType());
				
				if(!data.isEmpty())
				{
				    String fileName = data.getOriginalFilename();
					data.transferTo(new File("C:\\SpringBootProject\\upload_files\\" + fileName));
				}
			}
		}
		
		
		
//		if (!picture.isEmpty())
//		{
//			for (MultipartFile data : picture)
//			{
//				log.info("registerFileUp");
//				log.info("originalName: " + data.getOriginalFilename()); 
//				log.info("size: " + data.getSize()); 
//				log.info("contentType: " + data.getContentType());
//				
//				if(!data.isEmpty())
//				{
//				    String fileName = data.getOriginalFilename();
//					data.transferTo(new File("C:\\SpringBootProject\\upload_files\\" + fileName));
//				}
//			}
//		}
		
//		log.info("registerFileUp01");
//		log.info("originalName: " + picture1.getOriginalFilename()); 
//		log.info("size: " + picture1.getSize()); 
//		log.info("contentType: " + picture1.getContentType());
		
//		if(!picture1.isEmpty())
//		{
//		    String fileName = picture1.getOriginalFilename();
//			picture1.transferTo(new File("C:\\SpringBootProject\\upload_files\\" + fileName));
//		}
//		
//		log.info("registerFileUp02");
//		log.info("originalName: " + picture2.getOriginalFilename()); 
//		log.info("size: " + picture2.getSize()); 
//		log.info("contentType: " + picture2.getContentType());
//		
//		if(!picture2.isEmpty())
//		{
//		    String fileName = picture2.getOriginalFilename();
//			picture2.transferTo(new File("C:\\SpringBootProject\\upload_files\\" + fileName));
//		}
		return "home";
	}
	
	
	@RequestMapping(value = "/registerSpringFormCheckboxes01", method = RequestMethod.GET)
	public String registerSpringFormCheckboxes01(Model model)
	{	// Member.java 파일에 private List <String> hobbyList; 추가해줘야 함.
		log.info("registerSpringFormCheckboxes01");
		
		Map <String, String> hobbyMap = new HashMap <String, String>();
		
		hobbyMap.put("01", "Sports");
		hobbyMap.put("02", "Music");
		hobbyMap.put("03", "Movie");
		
		model.addAttribute("hobbyMap", hobbyMap);
		model.addAttribute("member", new Member());
		
		return "registerSpringFormCheckboxes01"; // 뷰 파일명.
	}
	
	@PostMapping(value = "/register06")
	public ResponseEntity <String> register06(@RequestBody List<Member> memberList)
	{
		log.info("register06");
		for(Member member : memberList) 
		{
			log.info("userId = " +
			member.getUserId());
			log.info("password = " + member.getPassword());
		}
		
		ResponseEntity <String> entity = new ResponseEntity <String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@PostMapping(value = "/uploadAjax", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception
	{
		String originalFilename = file.getOriginalFilename();
		
		log.info("registerFileUp");
		log.info("originalName: " + file.getOriginalFilename()); 
		log.info("size: " + file.getSize()); 
		log.info("contentType: " + file.getContentType());
		
		if(!file.isEmpty())
		{
		    String fileName = file.getOriginalFilename();
			file.transferTo(new File("C:\\SpringBootProject\\upload_files\\" + fileName));
		}
		
		log.info("originalName: " + originalFilename);
		
		ResponseEntity<String> entity = new ResponseEntity <String>("UPLOAD SUCCESS " + originalFilename, HttpStatus.OK);
		
		return entity;
	}

	@RequestMapping(value = "/registerSpringFormErrors", method = RequestMethod.GET)
	public String registerSpringFormErrors (Model model)
	{
		log.info("registerSpringFormErrors");
		
		Member member = new Member();
		
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		
		model.addAttribute("member", member);
		
		return "registerSpringFormErrors"; // 뷰 파일명.
	}
	
	// 입력 처리.
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Validated Member member, BindingResult result)
	{
		log.info("register");

		// 에러 처리.
		if (result.hasErrors())
		{
			return "registerSpringFormErrors";
		}
		
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getUserName() = " + member.getUserName());
		log.info("member.getEmail() = " + member.getEmail());
		
		return "errorsResult";
	}

//	@PostMapping (value = "/insert")
//	public String insertMember (Member member, Address address/*String car, @DateTimeFormat(pattern = "yyyyMMdd") Date dateOfBirth, Model model, int coin, Date dateOfBirth*/)
//	{
//		log.info("insertMember");
//		log.info("member.getUserId() = " + member.getUserId());
//		log.info("member.getPassword() = " + member.getPassword());
//		log.info("member.getCoin() = " + member.getCoin());
//		// log.info("coin = " + coin);
//		// log.info("date of birth = " + dateOfBirth);
//		log.info("member.getDateOfBirth = " + member.getDateOfBirth());
//		// log.info("member.yyyyMMdd = " + dateOfBirth);
//		// log.info("car = " + car);
//		// log.info("member.car = " + member.car); 하고, 위의 String car없애주면 됨. getters 하고.
//		if (member.getCar() != null)
//		{
//			for ( String data : member.getCar())
//			{
//				log.info("member.getCar = " + data);
//			}
//		}
//		log.info("member.toString()" + member.toString());
//		log.info("address.toString()" + address.toString());
//
//		return "home";
//	}
}