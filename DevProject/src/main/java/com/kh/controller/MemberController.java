package com.kh.controller;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
	
	
	// 입력값 검증.
	// 입력값 검증을 할 도메인 클래스에 @Vaildated를 지정한다. 
	@RequestMapping(value = "/registerValidation", method = RequestMethod.POST) 
	public String registerValidation(@Validated Member member, BindingResult
	result)
	{
	log.info("registerValidation");
	if(result.hasErrors())
	{
	return "registerValidationForm"; // 뷰 파일명
	}
	log.info("member.getUserId() = " + member.getUserId());
	log.info("member.getGender() = " + member.getUserName());
	log.info("member.getGender() = " + member.getGender());
	return "success";
	}
	
	// 입력값 검증을 위한 홈 화면 호출. (GET 방식)
	@RequestMapping(value = "/registerValidationForm01", method = RequestMethod.GET)
	public String registerForm01(Model model)
	{	// http://localhost:8080/member/registerValidationForm01
		log.info("registerValidationForm01");
		model.addAttribute("member", new Member());
		return "registerValidationForm"; // 뷰 파일명
	}
	
	// 전체적인 입력값 검증.
	// 입력값 검증을 할 도메인 클래스에 @Vaildated를 지정한다.
	@RequestMapping(value = "/registerValidation2", method = RequestMethod.POST)
	public String registerValidation2(@Validated Member member, BindingResult result)
	{
		log.info("registerValidation2");
		
		// 입력값 검증 에러가 발생한 경우 true를 반환한다.
		log.info("result.hasErrors() = " + result.hasErrors());
		
		// 입력값 검증 후 BindingResult가 제공하는 메서드를 이용하여 검사 결과를 확인한다.
		if (result.hasErrors())
		{
			List <ObjectError> allErrors = result.getAllErrors();
			List <ObjectError> globalErrors = result.getGlobalErrors();
			
			List <FieldError> fieldErrors = result.getFieldErrors();
			
			log.info("allErrors.size() = " + allErrors.size());
			log.info("globalErrors.size() = " + globalErrors.size());
			log.info("fieldErrors.size() = " + fieldErrors.size());
			
			for (int i = 0; i < allErrors.size(); i++)
			{
				ObjectError objectError = allErrors.get(i);
				
				log.info("allError = " + objectError);
			}
			
			for (int i = 0; i < globalErrors.size(); i++)
			{
				ObjectError objectError = globalErrors.get(i);
				
				log.info("globalError = " + objectError);
			}
			
			for (int i = 0; i < fieldErrors.size(); i++)
			{
				FieldError fieldError = fieldErrors.get(i);
				
				log.info("fieldError = " + fieldError);
				log.info("fieldError.getDefaultMessage() = " + fieldError.getDefaultMessage());
			}
			return "registerValidation2Form"; // 뷰 파일명
		}
		
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getGender() = " + member.getGender());
		
		return "home";
	}

	@RequestMapping(value = "/registerValidation2Form01", method = RequestMethod.GET)
	public String registerValidation2Form01(Model model)
	{	// 09-15p.
		// http://localhost:8080/member/registerValidation2Form01
		log.info("registerValidation2Form01");
		
		model.addAttribute("member", new Member());
		
		return "registerValidation2Form"; // 뷰 파일명.
	}

	@RequestMapping(value = "/registerValidation2Form02", method = RequestMethod.GET)
	public String registerValidation2Form02(Model model)
	{
		log.info("registerValidation2Form02");
		
		Member member = new Member();
		
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		member.setGender("female");
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateOfBirth(cal.getTime());
		
		model.addAttribute("member", member);
		
		return "registerValidation2Form"; // 뷰 파일명.
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