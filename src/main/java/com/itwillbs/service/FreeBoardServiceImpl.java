package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.FreeBoardDAO;
import com.itwillbs.domain.FreeBoardDTO;
import com.itwillbs.domain.PageDTO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

	@Inject
	private FreeBoardDAO freeBoardDAO;
	
	@Override
	public List<FreeBoardDTO> getBoardList(PageDTO pageDTO) {
		
		int currentPage =	Integer.parseInt(pageDTO.getPageNum());
		int startRow 	= 	(currentPage-1) * pageDTO.getPageSize() + 1;
		int endRow		=	startRow + pageDTO.getPageSize() - 1;
		
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setStartRow(startRow);
		pageDTO.setEndRow(endRow);
		pageDTO.setStartRow(startRow-1);
		
		return freeBoardDAO.getBoardList(pageDTO);
	}

	@Override
	public int getBoardCount() {
		return freeBoardDAO.getBoardCount();
	}

	@Override
	public void updateReadcount(int id) {
		freeBoardDAO.updateReadcount(id);
	}

	@Override
	public void writeBoard(FreeBoardDTO FBDTO) {
		freeBoardDAO.writeBoard(FBDTO);
	}

	@Override
	public Integer getMaxNum() {
		Integer num = freeBoardDAO.getMaxNum(); 
		return num == null ? 0 : num;
	}

	@Override
	public FreeBoardDTO getBoard(int id) {
		updateReadcount(id);
		return freeBoardDAO.getBoard(id);
	}

	@Override
	public void updateBoard(FreeBoardDTO FBDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int id) {
		freeBoardDAO.deleteBoard(id);
	}
	
	
	
	
}
