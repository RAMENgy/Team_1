package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.QnaDTO;

@Repository
public class QnaDAOImpl implements QnaDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.qnaMapper";

	@Override
	public List<QnaDTO> getBoardList(PageDTO pageDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".getBoardList", pageDTO);
	}

	@Override
	public int getBoardCount() {
		return sqlSession.selectOne(namespace+".getBoardCount");
	}

}
