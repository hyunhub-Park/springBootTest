package com.kh.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor	// 매개변수 생성자.
@NoArgsConstructor // default 생성자.
@Builder
public class User
{
	private int id;
	private String userName;
	private String passWord;
	private String email;
}