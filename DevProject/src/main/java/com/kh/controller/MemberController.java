package com.kh.controller;

import java.io.File;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kh.domain.FileMember;
import com.kh.domain.Member;

import lombok.extern.slf4j.Slf4j;

// @Log
@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController
{
	
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