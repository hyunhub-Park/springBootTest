package com.kh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.domain.Board;

import lombok.extern.slf4j.Slf4j;

// @Log
@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController
{
	
	@PutMapping (value = "/{boardNo}")
	public ResponseEntity <String> modify (@PathVariable("boardNo") int boardNo, @RequestBody Board board)
	{
		log.info("Modify Test...");
		
		ResponseEntity <String> entity = new ResponseEntity <String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	// X-HTTP-Method-Override 요청 헤더 값을 "PUT"으로 지정.
	@PutMapping (value = "/{boardNo}", headers = "X-HTTP-Method-Override=PUT")
	public ResponseEntity <String> modifyByHeader (@PathVariable ("boardNo") int boardNo, @RequestBody Board board)
	{
		log.info("Modify the header...");
		
		ResponseEntity <String> entity = new ResponseEntity <String> ("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	// 2번 과제.
//	@GetMapping(value = "/get", params="register") 
//	public String registerForm() {
//	log.info("params 파라미터 GET 방식 등록 폼");
//	return "board/register";
//	}
//	@PostMapping(value = "/post", params="register") 
//	public String register() {
//	log.info("params 파라미터 POST 방식 등록");
//	return "board/list";
//	}
//	@GetMapping(value = "/get", params="modify") 
//	public String modifyForm() {
//	log.info("params 파라미터 GET 방식 수정 폼");
//	return "board/modify";
//	}
//	@PostMapping(value = "/post", params="modify") 
//	public String modify() {
//	log.info("params 파라미터 POST 방식 수정");
//	return "board/list";
//	}
//	@GetMapping(value = "/get", params="remove") 
//	public String removeForm() {
//	log.info("params 파라미터 GET 방식 삭제 폼");
//	return "board/remove";
//	}
//	@PostMapping(value = "/post", params="remove") 
//	public String remove() {
//	log.info("params 파라미터 POST 방식 삭제");
//	return "board/list";
//	}
//	@GetMapping(value = "/get", params="list") 
//	public String list() {
//	log.info("params 파라미터 GET 방식 목록");
//	return "board/list";
//	}
//	@GetMapping(value = "/get", params="read") 
//	public String read() {
//	log.info("params 파라미터 GET 방식 읽기");
//	return "board/read";
//	}

	
	
	
	// 1번 과제.
//	// @RequestMapping의 value 속성에 요청 경로를 설정한다.
//	// register 경로에 GET 방식 설정
//	@GetMapping(value = "/register") 
//	public String registerForm() {
//	log.info("GET 방식 등록 폼");
//	return "success";
//	}
//	// register 경로에 POST 방식 설정
//	@PostMapping(value = "/register") 
//	public String register() {
//	log.info("POST 방식 등록");
//	return "success";
//	
//	}
//	// modify 경로에 GET 방식
//	@GetMapping(value = "/modify") 
//	public String modifyForm() {
//	log.info("GET 방식 수정 폼");
//	return "success";
//	}
//	// modify 경로에 POST 방식
//	@PostMapping(value = "/modify") 
//	public String modify() {
//	log.info("POST 방식 수정");
//	return "success";
//	}
//	// remove 경로에 POST 방식
//	@PostMapping(value = "/remove") 
//	public String remove() {
//	log.info("POST 방식 삭제");
//	return "success";
//	}
//	// list 경로에 GET 방식
//	@GetMapping(value = "/list") 
//	public String list() {
//	log.info("GET 방식 목록");
//	return "success";
//	}


//	@PutMapping(value="/{baordNoVal}")
//	public ResponseEntity<String> modify (@PathVariable("boardNoVal") int boardNoVal, @RequestBody Board board)
//	{
//		log.info("boardNoVal : " + boardNoVal);
//		log.info("board : " + board.toString());
//		
//		
//		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//		return entity;
//	}
//	
//	@PutMapping(value="/{baordNoVal}", 	headers="X-HTTP-Method-Override=PUT")
//	public ResponseEntity<String> modifyByHeader (@PathVariable("boardNoVal") int boardNoVal, @RequestBody Board board)
//	{
//		log.info("header boardNoVal : " + boardNoVal);
//		log.info("header board : " + board.toString());
//		
//		
//		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//		return entity;
//	}
//	@RequestMapping(value="/read/{readNo}", method = RequestMethod.GET)
//	public String read (@PathVariable("readNo") int readNo, Model model)
//	{
//		log.info("read NO : " + readNo);
//		return "home";
//	}
//	
//	@RequestMapping(value="/list", method = RequestMethod.GET)
//	public void list ()
//	{
//		log.info("board/list : " );
//		// return "home";
//	}
}