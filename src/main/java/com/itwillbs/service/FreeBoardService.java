package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.FreeBoardDTO;
import com.itwillbs.domain.PageDTO;

public interface FreeBoardService {
	
	public int getBoardCount();
	public void updateReadcount(int num);
	public List<FreeBoardDTO> getBoardList(PageDTO pageDTO);
	
}
