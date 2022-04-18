package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.LikeDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.RecipeDTO;

@Repository
public class LikeDAOImpl implements LikeDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.likeMapper";

	@Override
	public List<LikeDTO> getBoardList(int member_id) {
		return sqlSession.selectList(namespace+".getBoardList", member_id);
	}

	@Override
	public int getBoardCount(int member_id) {
		return sqlSession.selectOne(namespace+".getBoardCount", member_id);
	}

	@Override
	public void deleteBoard(int id) {
		sqlSession.delete(namespace+".deleteBoard", id);
	}

	@Override
	public LikeDTO getBoard(int member_id) {
		return sqlSession.selectOne(namespace+".getBoard", member_id);
	}

	@Override
	public List<LikeDTO> getBoardListSearch(RecipeDTO rDTO) {
		return sqlSession.selectList(namespace+".getBoardListSearch", rDTO);
	}

	@Override
	public int getBoardCountSearch(RecipeDTO rDTO) {
		return sqlSession.selectOne(namespace+".getBoardCountSearch", rDTO);
	}

	@Override
	public List<LikeDTO> getReList(RecipeDTO rDTO) {
		return sqlSession.selectList(namespace+".getReList", rDTO);
	}

	@Override
	public void likeUp(int id) {
		sqlSession.update(namespace+".likeUp", id);
	}

	@Override
	public void insertlike(LikeDTO lDTO) {
		sqlSession.insert(namespace+".insertlike", lDTO);
		
	}

	@Override
	public LikeDTO cklike(LikeDTO lDTO) {
		return sqlSession.selectOne(namespace+".cklike", lDTO);
	}

	@Override
	public void likeDown(int id) {
		sqlSession.update(namespace+".likeDown", id);
		
	}

	@Override
	public void deletelike(LikeDTO lDTO) {
		sqlSession.delete(namespace+".deletelike", lDTO);
		
	}
	
	
}
