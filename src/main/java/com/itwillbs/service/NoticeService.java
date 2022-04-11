package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.NoticeDTO;
import com.itwillbs.domain.PageDTO;

public interface NoticeService {
	
	public void writeBoard(NoticeDTO noticeDTO);
	
	public Integer getMaxNum();
	
	public List<NoticeDTO> getBoardList(PageDTO pageDTO);
	
	public int getBoardCount();
	
	public NoticeDTO getBoard(int num);
	
	public void updateReadcount(int num);
	
	public void updateBoard(NoticeDTO noticeDTO);
	
	public void deleteBoard(int num);
}
