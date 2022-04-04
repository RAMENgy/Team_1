package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.LikeDTO;
import com.itwillbs.domain.PageDTO;

public interface LikeDAO {
	
	public List<LikeDTO> getBoardList(int member_id);
	
	public int getBoardCount(int member_id);
}
