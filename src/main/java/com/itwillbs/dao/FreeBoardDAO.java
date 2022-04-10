package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.FreeBoardDTO;
import com.itwillbs.domain.PageDTO;

public interface FreeBoardDAO {

	public void writeBoard(FreeBoardDTO boardDTO);
	public Integer getMaxNum();
	public int getBoardCount();
	public FreeBoardDTO getBoard(int id);
	public List<FreeBoardDTO> getBoardList(PageDTO pageDTO);
	public void updateBoard(FreeBoardDTO boardDTO);
	public void updateReadcount(int id);
	public void deleteBoard(int id);
}
