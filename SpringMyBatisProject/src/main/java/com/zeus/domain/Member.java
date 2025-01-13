package com.zeus.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Member
{
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private Date regDate;
	private Date updDate;
	
	// 사용자는 관리자/사용자/회원 가입을 하려는 자 모두가 될 수 있음.
	// 1:n
	// List는 '다'가 될 수 있음. join되는 항목들이 list, 즉 n으로 오는 것.
	
	private List <MemberAuth> authList;
}