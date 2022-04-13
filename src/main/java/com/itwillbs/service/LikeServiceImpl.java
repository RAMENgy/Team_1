 package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.LikeDAO;
import com.itwillbs.domain.LikeDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.RecipeDTO;

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
	public int getBoardCount(int member_id) {
		return likeDAO.getBoardCount(member_id);
	}

	@Override
	public void deleteBoard(int id) {
		likeDAO.deleteBoard(id);
		
	}

	@Override
	public LikeDTO getBoard(int member_id) {
		return likeDAO.getBoard(member_id);
	}

	@Override
	public List<LikeDTO> getBoardListSearch(RecipeDTO rDTO) {
		return likeDAO.getBoardListSearch(rDTO);
	}

	@Override
	public int getBoardCountSearch(RecipeDTO rDTO) {
		return likeDAO.getBoardCountSearch(rDTO);
	}

	@Override
	public List<LikeDTO> getReList(RecipeDTO rDTO) {
		return likeDAO.getReList(rDTO);
	}

}
