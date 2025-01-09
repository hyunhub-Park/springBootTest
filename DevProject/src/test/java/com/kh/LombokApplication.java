package com.kh;

import java.util.Date;

import com.kh.domain.Board;
import com.kh.service.BoardService;

public class LombokApplication
{
	public static void main (String [] args)
	{
		BoardService bs = new BoardService();
		
		// @Builder로 생성된 Board만들기.
		Board board = Board.builder()
				.boardNo(1)
				.title("Builder Test")
				.content("Test")
				.regDate(new Date())
				.build();
		
		bs.create(board);
		bs.readByBoardNo(1);
		bs.delete(board);
	}
}