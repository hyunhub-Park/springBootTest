package com.zeus.mapper;

import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;

public interface MemberMapper
{	// MemberMapper.xml의 인터페이스.
	// Table 2개, domain도 2개.
	public void create(Member member) throws Exception;

	public void createAuth(MemberAuth memberAuth) throws Exception;
}