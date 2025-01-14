package com.zeus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;

public interface MemberMapper { // MemberMapper.xml의 인터페이스.
								// Table 2개, domain도 2개.
	public void create(Member member) throws Exception;

	public void createAuth(MemberAuth memberAuth) throws Exception;

	public Member read(int userNo) throws Exception;

	public void update(Member member) throws Exception;

	public List <Member> list() throws Exception;

	public void delete(int userNo) throws Exception;

	public void deleteAuth(int userNo) throws Exception;
	
	/* 검색 기능 추가. */
	// public List <Member> search(@Param("userId") String userId, @Param("userName") String userName) throws Exception;
	public List <Member> search(@Param("userId") String userId) throws Exception;
}