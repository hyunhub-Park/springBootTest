package com.kh;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.domain.Board;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@SpringBootTest
public class LombokTests
{
//	@Test
//	// 디폴트 생성자.
//	 public void testNoArgsConstructor ()
//	 {
//		// Board.java에 @NoArgsConstructor로 default생성자 생성.
//		Board board = new Board ();
//		System.out.println(board);
//	 }
//	
//	@Test
//	public void testRequiredArgsConstructor ()
//	{
//		// @RequiredArgsConstructor
//		Board board = new Board("Title");
//		System.out.println(board);
//	}
	
//	@Test
//	public void testGetter ()
//	{
//		Board board = new Board();
//		System.out.println(board.getTitle());
//	}
//	
//	@Test
//	public void testSetter ()
//	{
//		Board board = new Board();
//		board.setTitle("공지사항");
//		System.out.println(board.getTitle());
//		System.out.println(board.toString());
//	}
}