package com.kh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController	// @Controller + @ResponseBody
public class RESTController
{
	@GetMapping("blog")
	public User httpGetUser()
	{
		// @Builder는 모든 값을 넣어야 함.
		User user = User.builder()
						.id(1)
						.userName("zeus")
						.passWord("1234")
						.email("zeus@example.com")
						.build();
		return user;
	}
	
//	@GetMapping("blog")
//	public User httpGetUser()
//	{
//		// @Builder는 모든 값을 넣어야 함.
//		User user = User.builder()
//						.id(1)
//						.userName("zeus")
//						.passWord("1234")
//						.email("zeus@example.com")
//						.build();
//		return user;
//	}
	
//	@GetMapping("blog")
//	public String httpGet()
//	{
//		// view resolver 작동 안됨.
//		return "get 요청처리";
//	}
	
	@PostMapping("blog")
	// @ResponseBody -> 자바 객체를 json형식으로 변경하여 browser에게 전달.
	// @RequestBody -> browser가 json형식으로 전송하면 -> 자바 객체로 변경.
	public User httpPost(@RequestBody User user)
	//public List<User> httpPost(@RequestBody User user)
	{
		// view resolver 작동 안됨.
		// return "post 요청처리";
		// Postman - body -raw
//		{
//		    "id" : "1",
//		    "userName" : "zeus",
//		    "passWord" : "1234",
//		    "email" : "zeus@example.com"
//		}
//		String pass = user.getPassWord();
//		user.setPassWord(pass + "1111");
		
//		// 배열로 출력하기.
//		List <User> list = new ArrayList<User>();
//		list.add(user);
//		list.add(user);
		// return list;
		return user;
	}
	
//	@PostMapping("blog")
//	public String httpPost(User user)
//	{
//		// view resolver 작동 안됨.
//		// return "post 요청처리";
	// Postman의 body부분에 id, userName등 작성 후 send.
//		return "post 요청처리" + user.toString();
//	}
	
	
	
	@PutMapping("blog")
	public String httpPut()
	{
		// view resolver 작동 안됨.
		return "put 요청처리";
	}
	
	@DeleteMapping("blog")
	public String httpDelete()
	{
		// view resolver 작동 안됨.
		return "delete 요청처리";
	}
}