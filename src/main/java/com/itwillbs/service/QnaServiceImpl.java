package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.QnaDAO;
import com.itwillbs.domain.CommentDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.QnaDTO;
@Service
public class QnaServiceImpl implements QnaService{
	
	@Inject
	private QnaDAO qnaDAO;

	@Override
	public void writeBoard(QnaDTO qnaDTO) {
		// name,subject,content 폼에서 입력해서 옴
		// num,pass,readcount,date
		qnaDTO.setReadcount(0);
		qnaDTO.setDate(new Timestamp(System.currentTimeMillis()));
		
		qnaDAO.writeBoard(qnaDTO);
		
	}

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

	@Override
	public QnaDTO getBoard(int num) {
		return qnaDAO.getBoard(num);
	}

	@Override
	public void updateReadcount(int num) {
		qnaDAO.updateReadcount(num);
		
	}

	@Override
	public void updateBoard(QnaDTO qnaDTO) {
		qnaDAO.updateBoard(qnaDTO);
		
	}

	@Override
	public void deleteBoard(int num) {
		qnaDAO.deleteBoard(num);
		
	}

	@Override
	public void qnawriteBoard(QnaDTO qnaDTO) {
		qnaDTO.setReadcount(0);
		qnaDTO.setDate(new Timestamp(System.currentTimeMillis()));
		qnaDAO.qnawriteBoard(qnaDTO);
		
	}

	@Override
	public void commentBoard(CommentDTO commentDTO) {
		commentDTO.setDate(new Timestamp(System.currentTimeMillis()));
		qnaDAO.commentBoard(commentDTO);
		
	}

	@Override
	public CommentDTO getCommentBoard(int num) {
		return qnaDAO.getCommentBoard(num);
	}
	
	

	/*
	 * @Override public void commentupdateBoard(QnaDTO qnaDTO) {
	 * qnaDAO.commentupdateBoard(qnaDTO);
	 * 
	 * }
	 * 
	 * @Override public void commentdeleteBoard(int num) { qnaDAO.deleteBoard(num);
	 * 
	 * }
	 */

	@Override
	public List<QnaDTO> getBoardListSearch(PageDTO pageDTO) {
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
		
		
		return qnaDAO.getBoardListSearch(pageDTO);
	}

	@Override
	public int getBoardCountSearch(PageDTO pageDTO) {
		return qnaDAO.getBoardCountSearch(pageDTO);
	}

	
	

}
