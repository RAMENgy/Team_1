package com.itwillbs.service;

import java.util.List;
import java.sql.Timestamp;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.RecipeBoardDAO;
import com.itwillbs.domain.RecipeBoardDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.RBCommentDTO;

@Service
public class RecipeBoardServiceImpl implements RecipeBoardService{
	
	//DI 의존관계 주입 객체생성
	@Inject
	private RecipeBoardDAO recipeBoardDAO;
	
	@Inject
	private HttpSession session;
	
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
		int mi = (Integer)session.getAttribute("id");
		recipeboardDTO.setMember_id(mi);
		recipeboardDTO.setIngredient("1");
		recipeboardDTO.setReadcount(0);
		recipeboardDTO.setLike_count(0);
		recipeboardDTO.setDate(new Timestamp(System.currentTimeMillis()));
		
		recipeBoardDAO.writeBoard(recipeboardDTO);
	}


	@Override
	public int getBoardCount() {
		return recipeBoardDAO.getBoardCount();
	}


	@Override
	public RecipeBoardDTO getBoard(int id) {
		return recipeBoardDAO.getBoard(id);
	}


	@Override
	public void updateReadcount(int id) {
		recipeBoardDAO.updateReadcount(id);
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


	@Override
	public int pointUp(int id) {
		return recipeBoardDAO.pointUp(id);
	}


	@Override
	public Integer getMaxLike() {
		return recipeBoardDAO.getMaxLike();
	}
	
	@Override
	public void writeComment(RBCommentDTO RBCDTO) {
		recipeBoardDAO.writeComment(RBCDTO);
	}
	
	@Override
	public void deleteComment(int commentId) {
		recipeBoardDAO.deleteComment(commentId);
	}
	
	@Override
	public List<RBCommentDTO> getCommentList(int content_id) {
		return recipeBoardDAO.getCommentList(content_id);
	}
	
	@Override
	public Integer getMaxNum(boolean isRecipeBoard) {
		Integer num = recipeBoardDAO.getMaxNum(isRecipeBoard); 
		return num == null ? 0 : num;
	}
	
}
