package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.QnaDTO;

public interface QnaDAO {
	
	public List<QnaDTO> getBoardList(PageDTO pageDTO);
	
	public int getBoardCount();
}
