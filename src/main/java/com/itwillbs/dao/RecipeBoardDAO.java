package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.RecipeBoardDTO;
import com.itwillbs.domain.PageDTO;

public interface RecipeBoardDAO {
	// 추상메서드 정의
	public void writeBoard(RecipeBoardDTO recipeboardDTO);
	
	public List<RecipeBoardDTO> getBoardList(PageDTO pageDTO);
	
	public int getBoardCount();
	
	public RecipeBoardDTO getBoard(int member_id);
	
	public void updateReadcount(int member_id);
	
	public void updateBoard(RecipeBoardDTO boardDTO);
	
	public void deleteBoard(int id);
	
	//검색
	
	public List<RecipeBoardDTO> getBoardListSearch(PageDTO pageDTO);
			
	public int getBoardCountSearch(PageDTO pageDTO);
	
}
