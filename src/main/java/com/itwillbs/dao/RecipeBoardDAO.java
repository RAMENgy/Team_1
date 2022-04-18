package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.RecipeBoardDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.RBCommentDTO;

public interface RecipeBoardDAO {
	// 추상메서드 정의
	public void writeBoard(RecipeBoardDTO recipeboardDTO);
	
	public List<RecipeBoardDTO> getBoardList(PageDTO pageDTO);
	
	public int getBoardCount();
	
	public RecipeBoardDTO getBoard(int member_id);
	
	public RecipeBoardDTO getBestBoard(int member_id);
	
	public void updateReadcount(int member_id);
	
	public void updateBoard(RecipeBoardDTO rbDTO);
	
	public void deleteBoard(int id);
	
	//검색
	
	public List<RecipeBoardDTO> getBoardListSearch(PageDTO pageDTO);
			
	public int getBoardCountSearch(PageDTO pageDTO);
	
	public int pointUp(int id);
	
	public Integer getMaxLike();
	
	//댓글
	
	public List<RBCommentDTO> getCommentList(int content_id);
	
	public void writeComment(RBCommentDTO RBCDTO);
	
	public void deleteComment(int commentId);
	
	public Integer getMaxNum(boolean isRecipeBoard);
	
}
