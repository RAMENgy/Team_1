package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.LikeDTO;
import com.itwillbs.domain.RecipeDTO;

public interface LikeService {
	
	public List<LikeDTO> getBoardList(int member_id);
	
	public int getBoardCount(int member_id);
	
	public LikeDTO getBoard(int member_id);

	public void deleteBoard(int id);
	
	public List<LikeDTO> getBoardListSearch(RecipeDTO rDTO);
	
	public int getBoardCountSearch(RecipeDTO rDTO);
}
