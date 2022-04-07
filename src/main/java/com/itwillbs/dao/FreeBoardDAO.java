package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.FreeBoardDTO;
import com.itwillbs.domain.PageDTO;

public interface FreeBoardDAO {

	public int getBoardCount();
	public void updateReadcount(int num);
	public List<FreeBoardDTO> getBoardList(PageDTO pageDTO);
	
}
