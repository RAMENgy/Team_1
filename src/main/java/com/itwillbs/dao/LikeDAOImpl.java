package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.LikeDTO;
import com.itwillbs.domain.PageDTO;

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
	
	
}
