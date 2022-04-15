package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.FBCommentDTO;
import com.itwillbs.domain.FreeBoardDTO;
import com.itwillbs.domain.PageDTO;

@Repository
public class FreeBoardDAOImpl implements FreeBoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.freeboardMapper";
	
	@Override
	public List<FreeBoardDTO> getBoardList(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".getBoardList", pageDTO);
	}
	
	@Override
	public int getBoardCount() {
		return sqlSession.selectOne(namespace+".getBoardCount");
	}

	@Override
	public void updateReadcount(int id) {
		sqlSession.update(namespace+".updateReadcount",id);
	}

	@Override
	public void writeBoard(FreeBoardDTO FBDTO) {
		sqlSession.insert(namespace+".writeBoard", FBDTO);
	}

	@Override
	public Integer getMaxNum(boolean isFreeBoard) {
		if (isFreeBoard) return sqlSession.selectOne(namespace+".getMaxNum");
		else return sqlSession.selectOne(namespace+".getMaxNumComment");
	}

	@Override
	public FreeBoardDTO getBoard(int id) {
		return sqlSession.selectOne(namespace+".getBoard", id);
	}

	@Override
	public void updateBoard(FreeBoardDTO FBDTO) {
		sqlSession.update(namespace+".updateBoard", FBDTO);
	}

	@Override
	public void deleteBoard(int id) {
		sqlSession.delete(namespace+".deleteBoard", id);
	}

	@Override
	public void writeComment(FBCommentDTO FBCDTO) {
		sqlSession.insert(namespace+".writeComment", FBCDTO);
	}

	@Override
	public List<FBCommentDTO> getCommentList(int content_id) {
		return sqlSession.selectList(namespace+".getCommentList", content_id);
	}

	@Override
	public List<FreeBoardDTO> getSearchList(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".getSearchList", pageDTO);
	}

	@Override
	public void deleteComment(int commentId) {
		sqlSession.delete(namespace+".deleteComment", commentId);
	}
	
}
