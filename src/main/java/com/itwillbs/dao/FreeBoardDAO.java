package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.FreeBoardDTO;
import com.itwillbs.domain.PageDTO;

public interface FreeBoardDAO {

	public List<FreeBoardDTO> getBoardList(PageDTO pageDTO);
	
}
