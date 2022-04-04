package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.LikeDTO;
import com.itwillbs.domain.PageDTO;

public interface LikeService {
	
	public List<LikeDTO> getBoardList(int member_id);
	
	public int getBoardCount(int member_id);

}
