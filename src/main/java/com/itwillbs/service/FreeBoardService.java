package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.FreeBoardDTO;
import com.itwillbs.domain.PageDTO;

public interface FreeBoardService {
	
	public List<FreeBoardDTO> getBoardList(PageDTO pageDTO);
	
}
