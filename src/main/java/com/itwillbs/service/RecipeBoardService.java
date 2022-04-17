package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.RecipeBoardDTO;
import com.itwillbs.domain.PageDTO;

public interface RecipeBoardService {
	
	// 추상메서드 정의
	public List<RecipeBoardDTO> getBoardList(PageDTO pageDTO);
	
	public void writeBoard(RecipeBoardDTO RecipeboardDTO);
	
	public int getBoardCount();
	
	public RecipeBoardDTO getBoard(int member_id);
	
	public void updateReadcount(int member_id);
	
	public void updateBoard(RecipeBoardDTO RecipeboardDTO);
	
	public void deleteBoard(int id);
	
	//검색
	
	public List<RecipeBoardDTO> getBoardListSearch(PageDTO pageDTO);
	
	public int getBoardCountSearch(PageDTO pageDTO); 
	
	public int pointUp(int id);
	
	public Integer getMaxLike();
	
}
