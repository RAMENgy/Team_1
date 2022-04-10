package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
	public void writeBoard(FreeBoardDTO boardDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getMaxNum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FreeBoardDTO getBoard(int id) {
		return sqlSession.selectOne(namespace+".getBoard", id);
	}

	@Override
	public void updateBoard(FreeBoardDTO boardDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
