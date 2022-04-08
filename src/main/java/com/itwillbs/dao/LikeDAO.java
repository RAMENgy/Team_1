package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.LikeDTO;

public interface LikeDAO {
	
	public List<LikeDTO> getBoardList(int member_id);
	
	public int getBoardCount(int member_id);
	
	public void deleteBoard(int id);
	
	public LikeDTO getBoard(int member_id);
	
	public List<LikeDTO> getBoardListSearch(int member_id);
	
	public int getBoardCountSearch(int member_id);
}
