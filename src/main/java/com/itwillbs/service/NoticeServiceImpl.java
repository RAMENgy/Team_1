package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.NoticeDAO;
import com.itwillbs.domain.NoticeDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.QnaDTO;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Inject
	private NoticeDAO noticeDAO;

	@Override
	public void writeBoard(NoticeDTO noticeDTO) {
		noticeDTO.setDate(new Timestamp(System.currentTimeMillis()));
		// 게시글 고유 번호가 계속 중복됨
		// getMaxNum으로 최대값 가져온 후 +1 해서 게시글 번호 세팅
		noticeDTO.setId(getMaxNum()+1);
		noticeDAO.writeBoard(noticeDTO);
		
	}


	@Override
	public List<NoticeDTO> getBoardList(PageDTO pageDTO) {
		
		int currentPage=Integer.parseInt(pageDTO.getPageNum());
		int startRow = (currentPage-1)*pageDTO.getPageSize()+1;
		int endRow=startRow+pageDTO.getPageSize()-1;
	
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setStartRow(startRow);
		pageDTO.setEndRow(endRow);
	
		pageDTO.setStartRow(startRow-1);
		return noticeDAO.getBoardList(pageDTO);
	}

	@Override
	public int getBoardCount() {
		return noticeDAO.getBoardCount();
	}

	@Override
	public NoticeDTO getBoard(int num) {
		return noticeDAO.getBoard(num);
	}

	@Override
	public void updateReadcount(int num) {
		noticeDAO.updateReadcount(num);
		
	}

	@Override
	public void updateBoard(NoticeDTO noticeDTO) {
		noticeDAO.updateBoard(noticeDTO);
		
	}

	@Override
	public void deleteBoard(int num) {
		noticeDAO.deleteBoard(num);
		
	}
	
	@Override
	public List<NoticeDTO> getBoardListSearch(PageDTO pageDTO) {
	// pageSize , pageNum 가져옴
	// currentPage, startRow , endRow 구하기 
	
	int currentPage=Integer.parseInt(pageDTO.getPageNum());
	int startRow = (currentPage-1)*pageDTO.getPageSize()+1;
	int endRow=startRow+pageDTO.getPageSize()-1;
	
	pageDTO.setCurrentPage(currentPage);
	pageDTO.setStartRow(startRow);
	pageDTO.setEndRow(endRow);
	

	pageDTO.setStartRow(startRow-1);
		
		
		return noticeDAO.getBoardListSearch(pageDTO);
	}

	@Override
	public int getBoardCountSearch(PageDTO pageDTO) {
		return noticeDAO.getBoardCountSearch(pageDTO);
	}


	@Override
	public Integer getMaxNum() {
		Integer num = noticeDAO.getMaxNum(); 
		return num == null ? 0 : num;
	}


	@Override
	public List<NoticeDTO> main1() {
		return noticeDAO.main1();
	}


	@Override
	public List<NoticeDTO> main2() {
		return noticeDAO.main2();
	}
	
	
	
}
