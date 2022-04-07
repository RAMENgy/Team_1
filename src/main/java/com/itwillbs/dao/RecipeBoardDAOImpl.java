package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.RecipeBoardDTO;
import com.itwillbs.domain.PageDTO;

@Repository
public class RecipeBoardDAOImpl implements RecipeBoardDAO {
	
	// 마이바티스 객체생성
	@Inject
	private SqlSession sqlSession;
	
	// sql구문 전체 이름 변수 정의
	private static final String namespace="com.itwillbs.mappers.recipeboardMapper";
	
	@Override
	public void writeBoard(RecipeBoardDTO recipeboardDTO) {
		sqlSession.insert(namespace+".writeBoard", recipeboardDTO);
	}

	@Override
	public Integer getMaxNum() {
		return sqlSession.selectOne(namespace+".getMaxNum");
	}
	
	@Override
	public List<RecipeBoardDTO> getBoardList(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".getBoardList", pageDTO);
	}
	
	@Override
	public int getBoardCount() {
		return sqlSession.selectOne(namespace+".getBoardCount");
	}

	@Override
	public RecipeBoardDTO getBoard(int member_id) {
		return sqlSession.selectOne(namespace+".getBoard", member_id);
	}

	@Override
	public void updateReadcount(int member_id) {
		sqlSession.update(namespace+".updateReadcount", member_id);
	}

	@Override
	public void updateBoard(RecipeBoardDTO recipeboardDTO) {
		sqlSession.update(namespace+".updateBoard", recipeboardDTO);
	}

	@Override
	public void deleteBoard(int id) {
		sqlSession.delete(namespace+".deleteBoard", id);
	}
	
	//검색
	
	@Override
	public List<RecipeBoardDTO> getBoardListSearch(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".getBoardListSearch", pageDTO);
	}

	@Override
	public int getBoardCountSearch(PageDTO pageDTO) {
		return sqlSession.selectOne(namespace+".getBoardCountSearch", pageDTO);
	}
	
	
}
