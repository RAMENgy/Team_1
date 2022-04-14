package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.NoticeDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.QnaDTO;

@Repository
public class NoticeDAOImpl implements NoticeDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.noticeMapper";

	@Override
	public void writeBoard(NoticeDTO noticeDTO) {
		sqlSession.insert(namespace+".writeBoard", noticeDTO);
		
	}

	@Override
	public Integer getMaxNum() {
		return sqlSession.selectOne(namespace+".getMaxNum");
	}

	@Override
	public List<NoticeDTO> getBoardList(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".getBoardList", pageDTO);
	}

	@Override
	public int getBoardCount() {
		return sqlSession.selectOne(namespace+".getBoardCount");
	}

	@Override
	public NoticeDTO getBoard(int num) {
		int id=num;
		return sqlSession.selectOne(namespace+".getBoard", id);
	}

	@Override
	public void updateReadcount(int num) {
		int id=num;
		sqlSession.update(namespace+".updateReadcount", id);
		
	}

	@Override
	public void updateBoard(NoticeDTO noticeDTO) {
		sqlSession.update(namespace+".updateBoard", noticeDTO);
		
	}

	@Override
	public void deleteBoard(int num) {
		int id=num;
		sqlSession.delete(namespace+".deleteBoard", id);
		
	}
	
	@Override
	public List<NoticeDTO> getBoardListSearch(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".getBoardListSearch", pageDTO);
	}

	@Override
	public int getBoardCountSearch(PageDTO pageDTO) {
		return sqlSession.selectOne(namespace+".getBoardCountSearch", pageDTO);
	}
	
}
