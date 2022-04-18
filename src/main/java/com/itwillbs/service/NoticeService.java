package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.NoticeDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.QnaDTO;

public interface NoticeService {
	
	public void writeBoard(NoticeDTO noticeDTO);
	
	public List<NoticeDTO> getBoardList(PageDTO pageDTO);
	
	public int getBoardCount();
	
	public NoticeDTO getBoard(int num);
	
	public void updateReadcount(int num);
	
	public void updateBoard(NoticeDTO noticeDTO);
	
	public void deleteBoard(int num);
	
	// 검색 
	public List<NoticeDTO> getBoardListSearch(PageDTO pageDTO);
		
	public int getBoardCountSearch(PageDTO pageDTO);
	
	public Integer getMaxNum();
	
	public List<NoticeDTO> main1();
	
	public List<NoticeDTO> main2();
}
