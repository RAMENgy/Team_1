package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.NoticeDAO;
import com.itwillbs.domain.NoticeDTO;
import com.itwillbs.domain.PageDTO;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Inject
	private NoticeDAO noticeDAO;

	@Override
	public void writeBoard(NoticeDTO noticeDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getMaxNum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeDTO> getBoardList(PageDTO pageDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBoardCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NoticeDTO getBoard(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateReadcount(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard(NoticeDTO noticeDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		
	}
	
}
