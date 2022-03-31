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
	public int getBoardCount() {
		return sqlSession.selectOne(namespace+".getBoardCount");
	}
	
	
}
