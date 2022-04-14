package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.QnaDTO;
import com.itwillbs.domain.CommentDTO;
import com.itwillbs.domain.PageDTO;

public interface QnaService {
	
	public void writeBoard(QnaDTO qnaDTO);
	
	public List<QnaDTO> getBoardList(PageDTO pageDTO);
	
	public int getBoardCount();
	
	public QnaDTO getBoard(int num);
	
	public void updateReadcount(int num);
	
	public void updateBoard(QnaDTO boardDTO);
	
	public void deleteBoard(int num);
	
	public void qnawriteBoard(QnaDTO qnaDTO);
	
	public void commentBoard(CommentDTO commentDTO);
	
	public CommentDTO getCommentBoard(int num);
	
	/*
	 * public void commentupdateBoard(QnaDTO qnaDTO);
	 * 
	 * public void commentdeleteBoard(int num);
	 */
	
	// 검색 
	public List<QnaDTO> getBoardListSearch(PageDTO pageDTO);
		
	public int getBoardCountSearch(PageDTO pageDTO);
}
