package com.zeus.service;

import java.util.List;
import com.zeus.domain.Board;

public interface BoardService
{	// BoardMapper와 이름 동일하게 작성해도 상관 없음.
	public void register(Board board) throws Exception;

	public Board read(Integer boardNo) throws Exception;

	public void modify(Board board) throws Exception;

	public void remove(Integer boardNo) throws Exception;

	public List <Board> list() throws Exception;
}