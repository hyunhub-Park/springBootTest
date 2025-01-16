package com.zeus.service;

import java.util.List;
import com.zeus.domain.Board;
import com.zeus.domain.Member;

public interface MemberService
{	// MemberMapper와 이름 동일하게 작성해도 상관 없음.
	public void register(Member member) throws Exception;
	
	public List <Member> list() throws Exception;
	
	public Member read(int userNo) throws Exception;
	
	public void modify(Member member) throws Exception;
	
	public void remove(int userNo) throws Exception;


	/* [단일] 검색기능 추가. */
	// public List <Member> search (String userId) throws Exception;
	
	/* [다중] 검색기능 추가. */
	public List<Member> search(String searchKeyword) throws Exception;
}