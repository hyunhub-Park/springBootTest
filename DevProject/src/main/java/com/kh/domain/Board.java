package com.kh.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
//@AllArgsConstructor	// 모든 매개변수를 받을 수 있는 생성자.
//@Getter
//@Setter
@NoArgsConstructor	// dafault 생성자 생성.
@RequiredArgsConstructor
@Builder
@ToString(exclude = "content")
//@ToString
@EqualsAndHashCode(of="boardNo")
public class Board 
{
	private int boardNo;
	@NonNull	// title = not null. ex)Board(String)
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	
	public Board(int boardNo, @NonNull String title, String content, String writer, Date regDate)
	{
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
	}
	
	
	


}
