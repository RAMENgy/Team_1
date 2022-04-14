package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.CommentDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.QnaDTO;
@Repository
public class QnaDAOImpl implements QnaDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	//sql구문 전체 이름 변수 정의
	private static final String namespace="com.itwillbs.mappers.qnaMapper";

	@Override
	public void writeBoard(QnaDTO qnaDTO) {
		sqlSession.insert(namespace+".writeBoard", qnaDTO);
		
	}

	@Override
	public Integer getMaxNum() {
		return sqlSession.selectOne(namespace+".getMaxNum");
	}

	@Override
	public List<QnaDTO> getBoardList(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".getBoardList", pageDTO);
		
	}

	@Override
	public int getBoardCount() {
		return sqlSession.selectOne(namespace+".getBoardCount");
	}

	@Override
	public QnaDTO getBoard(int num) {
		int id=num;
		return sqlSession.selectOne(namespace+".getBoard", id);
	}

	@Override
	public void updateReadcount(int num) {
		int id=num;
		sqlSession.update(namespace+".updateReadcount", id);
	}

	@Override
	public void updateBoard(QnaDTO qnaDTO) {
		sqlSession.update(namespace+".updateBoard", qnaDTO);
	}

	@Override
	public void deleteBoard(int num) {
		int id=num;
		sqlSession.delete(namespace+".deleteBoard", id);
	}

	@Override
	public void qnawriteBoard(QnaDTO qnaDTO) {
		sqlSession.insert(namespace+".qnawriteBoard", qnaDTO);
		
	}

	@Override
	public void commentBoard(CommentDTO commentDTO) {
		sqlSession.insert(namespace+".commentBoard", commentDTO);
		
	}

	@Override
	public CommentDTO getCommentBoard(int num) {
		int qna_board_id=num;
		return sqlSession.selectOne(namespace+".getCommentBoard", qna_board_id);
	}
	
	/*
	 * @Override public void commentupdateBoard(QnaDTO qnaDTO) {
	 * sqlSession.update(namespace+".commentupdateBoard", qnaDTO);
	 * 
	 * }
	 * 
	 * @Override public void commentdeleteBoard(int num) { int id=num;
	 * sqlSession.delete(namespace+".commentdeleteBoard", id);
	 * 
	 * }
	 */

	@Override
	public List<QnaDTO> getBoardListSearch(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".getBoardListSearch", pageDTO);
	}

	@Override
	public int getBoardCountSearch(PageDTO pageDTO) {
		return sqlSession.selectOne(namespace+".getBoardCountSearch", pageDTO);
	}

	
	
	
	

}
