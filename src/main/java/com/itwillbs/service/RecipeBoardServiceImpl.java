package com.itwillbs.service;

import java.util.List;
import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.RecipeBoardDAO;
import com.itwillbs.domain.RecipeBoardDTO;
import com.itwillbs.domain.PageDTO;

@Service
public class RecipeBoardServiceImpl implements RecipeBoardService{
	
	//DI 의존관계 주입 객체생성
	@Inject
	private RecipeBoardDAO recipeBoardDAO;
	
	
	@Override
	public List<RecipeBoardDTO> getBoardList(PageDTO pageDTO) {
		
		int currentPage =	Integer.parseInt(pageDTO.getPageNum());
		int startRow 	= 	(currentPage-1) * pageDTO.getPageSize() + 1;
		int endRow		=	startRow + pageDTO.getPageSize() - 1;
		
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setStartRow(startRow);
		pageDTO.setEndRow(endRow);
		pageDTO.setStartRow(startRow-1);
		
		return recipeBoardDAO.getBoardList(pageDTO);
	}
	
	
	@Override
	public void writeBoard(RecipeBoardDTO recipeboardDTO) {
		// name,subject,content 폼에서 입력해서 옴
		//num,pass,readcount,date
		recipeboardDTO.setMember_id(1111);
		recipeboardDTO.setReadcount(0);
		recipeboardDTO.setDate(new Timestamp(System.currentTimeMillis()));
		
		// 글번호 :  디비에 저장된 최대번호 구해서 +1 
		if(recipeBoardDAO.getMaxNum()!=null) {
			// 글이 있는 경우 
			recipeboardDTO.setId(recipeBoardDAO.getMaxNum()+1);
		}else {
			// 글이 없는 경우 
			recipeboardDTO.setId(1);
		}
		
		
		recipeBoardDAO.writeBoard(recipeboardDTO);
	}


	@Override
	public int getBoardCount() {
		return recipeBoardDAO.getBoardCount();
	}


	@Override
	public RecipeBoardDTO getBoard(int member_id) {
		return recipeBoardDAO.getBoard(member_id);
	}


	@Override
	public void updateReadcount(int member_id) {
		recipeBoardDAO.updateReadcount(member_id);
	}


	@Override
	public void updateBoard(RecipeBoardDTO RecipeboardDTO) {
		recipeBoardDAO.updateBoard(RecipeboardDTO);
	}


	@Override
	public void deleteBoard(int id) {
		recipeBoardDAO.deleteBoard(id);
	}
	
	@Override
	public List<RecipeBoardDTO> getBoardListSearch(PageDTO pageDTO) {
		// pageSize , pageNum 가져옴
		// currentPage, startRow , endRow 구하기 
		
		int currentPage=Integer.parseInt(pageDTO.getPageNum());
		int startRow = (currentPage-1)*pageDTO.getPageSize()+1;
		int endRow=startRow+pageDTO.getPageSize()-1;
		
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setStartRow(startRow);
		pageDTO.setEndRow(endRow);
		
//		select * from board order by num desc limit #{startRow}-1,#{pageSize}
		pageDTO.setStartRow(startRow-1);
		
		
		return recipeBoardDAO.getBoardListSearch(pageDTO);
	}

	@Override
	public int getBoardCountSearch(PageDTO pageDTO) {
				
		return recipeBoardDAO.getBoardCountSearch(pageDTO);
	}
	
}
