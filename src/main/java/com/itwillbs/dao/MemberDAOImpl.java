package com.itwillbs.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	// 마이바티스 객체 생성
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.memberMapper";

	
	
	
	
	@Override
	public MemberDTO getMember(String userid) {
		return sqlSession.selectOne(namespace+".getMember", userid);
	}
	
	@Override
	public void updateMember(MemberDTO memberDTO) {
		sqlSession.update(namespace+".updateMember", memberDTO);
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		return sqlSession.selectOne(namespace+".userCheck", memberDTO);
	}

	@Override
	public void insertMember(MemberDTO memberDTO) {
		sqlSession.insert(namespace+".insertMember", memberDTO);
		
	}

	
	
	
	
	
}
