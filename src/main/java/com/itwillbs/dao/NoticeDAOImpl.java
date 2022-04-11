package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.NoticeDTO;
import com.itwillbs.domain.PageDTO;

@Repository
public class NoticeDAOImpl implements NoticeDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.noticeMapper";

	@Override
	public void writeBoard(NoticeDTO noticeDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getMaxNum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeDTO> getBoardList(PageDTO pageDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBoardCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NoticeDTO getBoard(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateReadcount(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard(NoticeDTO noticeDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		
	}
	
	
}
