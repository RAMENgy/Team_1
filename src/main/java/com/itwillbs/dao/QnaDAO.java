package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.QnaDTO;
import com.itwillbs.domain.CommentDTO;
import com.itwillbs.domain.PageDTO;

public interface QnaDAO {
	public void writeBoard(QnaDTO qnaDTO);
	
	public Integer getMaxNum();
	
	public List<QnaDTO> getBoardList(PageDTO pageDTO);
	
	public List<QnaDTO> getMyBoardList(PageDTO pageDTO);
	
	public int getBoardCount();
	
	public QnaDTO getBoard(int num);
	
	public void updateReadcount(int num);
	
	public void updateBoard(QnaDTO qnaDTO);
	
	public void deleteBoard(int num);
	
	
	public void commentBoard(CommentDTO commentDTO);
	
	public CommentDTO getCommentBoard(int num);
	
	
	public void commentupdateBoard(CommentDTO commentDTO);
	
	public void commentdeleteBoard(int num);
	
	
	
	
	// 검색
	public List<QnaDTO> getBoardListSearch(PageDTO pageDTO);
			
	public int getBoardCountSearch(PageDTO pageDTO);
}
