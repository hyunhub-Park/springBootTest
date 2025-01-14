package com.zeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;
import com.zeus.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService
{
	@Autowired
	private MemberMapper mapper;
	
	@Transactional
	@Override
	// 삽입 요청.
	public void register(Member member) throws Exception
	{
		mapper.create(member);
		
		MemberAuth memberAuth = new MemberAuth();
		
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_USER");
		
		// 회원 권한 삽입. ROLE_USER
		mapper.createAuth(memberAuth);
	}

	@Override
	public List <Member> list() throws Exception
	{
		
		return mapper.list();
	}

	@Override
	// 회원 정보 요청.
	public Member read(int userNo) throws Exception
	{
		return mapper.read(userNo);
	}

	@Transactional
	@Override
	// 회원 정보 수정.
	public void modify(Member member) throws Exception
	{
		mapper.update(member);
		
		int userNo = member.getUserNo();
		
		// 회원 권한 삭제 후,
		mapper.deleteAuth(userNo);
		
		// 회원 권한을 다시 가져옴.
		List <MemberAuth> authList = member.getAuthList();
		
		for (int i = 0; i < authList.size(); i++)
		{
			MemberAuth memberAuth = authList.get(i);
			String auth = memberAuth.getAuth();
			
			if (auth == null)
			{
				continue;
			}
			
			if (auth.trim().length() == 0)
			{
				continue;
			}
			memberAuth.setUserNo(userNo);
			
			mapper.createAuth(memberAuth);
		}
	}

	@Transactional
	@Override
	// 회원 삭제.
	public void remove(int userNo) throws Exception
	{
		// 삭제 순서. join이 진행되었기 때문에 참조 '한 것'을 먼저 삭제,
		// 후에 참조 '된 것'을 삭제.
		mapper.deleteAuth(userNo);
		mapper.delete(userNo);
	}

	@Override
	public List <Member> search(String userId) throws Exception
	{
		return mapper.search(userId);
	}
}