package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.QnaDTO;

public interface QnaService {
	public List<QnaDTO> getBoardList(PageDTO pageDTO);
	
	public int getBoardCount();

}
