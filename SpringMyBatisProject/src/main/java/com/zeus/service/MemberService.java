package com.zeus.service;

import java.util.List;
import com.zeus.domain.Board;
import com.zeus.domain.Member;

public interface MemberService
{	// MemberMapper와 이름 동일하게 작성해도 상관 없음.
	public void register(Member member) throws Exception;
}