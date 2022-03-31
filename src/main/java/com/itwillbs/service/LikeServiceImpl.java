package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.LikeDAO;
import com.itwillbs.domain.LikeDTO;
import com.itwillbs.domain.PageDTO;

@Service
public class LikeServiceImpl implements LikeService{
	
	@Inject
	LikeDAO likeDAO;

	@Override
	public List<LikeDTO> getBoardList(int member_id) {
		// pageSize , pageNum 가져옴
		// currentPage, startRow , endRow 구하기 
		
//		int currentPage=Integer.parseInt(pageDTO.getPageNum());
//		int startRow = (currentPage-1)*pageDTO.getPageSize()+1;
//		int endRow=startRow+pageDTO.getPageSize()-1;
//		
//		pageDTO.setCurrentPage(currentPage);
//		pageDTO.setStartRow(startRow);
//		pageDTO.setEndRow(endRow);
//		
////				select * from board order by num desc limit #{startRow}-1,#{pageSize}
//		pageDTO.setStartRow(startRow-1);
		
		return likeDAO.getBoardList(member_id);
	}

	@Override
	public int getBoardCount() {
		return likeDAO.getBoardCount();
	}

}
