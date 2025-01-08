package com.kh.domain;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
//@AllArgsConstructor	// 모든 매개변수를 받을 수 있는 생성자.
//@Getter
//@Setter
// @Builder
@ToString(exclude = "content")
//@ToString
@EqualsAndHashCode(of="boardNo")
public class Member 
{
	private String userId; 
	private String userName; 
	private String password; 
	private Date dateOfBirth;
	private int coin;



}
