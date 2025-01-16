package com.zeus.domain;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Board
{
	private int boardNo;
	
	// 입력값의 검사 규칙을 지정.
	@NotBlank
	private String title; 
	private String content; 
	private String writer; 
	private Date regDate;
}