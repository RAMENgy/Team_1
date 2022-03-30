package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.QnaDAO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.QnaDTO;

@Service
public class QnaServiceImpl implements QnaService{
	
	@Inject
	private QnaDAO qnaDAO;

	@Override
	public List<QnaDTO> getBoardList(PageDTO pageDTO) {
		// pageSize , pageNum 가져옴
				// currentPage, startRow , endRow 구하기 
				
		int currentPage=Integer.parseInt(pageDTO.getPageNum());
		int startRow = (currentPage-1)*pageDTO.getPageSize()+1;
		int endRow=startRow+pageDTO.getPageSize()-1;
				
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setStartRow(startRow);
		pageDTO.setEndRow(endRow);
				
		pageDTO.setStartRow(startRow-1);
		
		return qnaDAO.getBoardList(pageDTO);
	}

	@Override
	public int getBoardCount() {
		return qnaDAO.getBoardCount();
	}

}
