package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.FBCommentDTO;
import com.itwillbs.domain.FreeBoardDTO;
import com.itwillbs.domain.PageDTO;

public interface FreeBoardService {
	
	public void writeBoard(FreeBoardDTO boardDTO);
	public Integer getMaxNum(boolean isFreeBoard);
	public int getBoardCount();
	public FreeBoardDTO getBoard(int id);
	public List<FBCommentDTO> getCommentList(int content_id);
	public List<FreeBoardDTO> getBoardList(PageDTO pageDTO);
	public void updateBoard(FreeBoardDTO boardDTO);
	public void updateReadcount(int id);
	public void deleteBoard(int id);
	public void writeComment(FBCommentDTO FBCDTO);
	public List<FreeBoardDTO> getSearchList(PageDTO pageDTO);
	
}
