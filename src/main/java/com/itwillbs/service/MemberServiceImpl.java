package com.itwillbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO memberDAO;
	
	@Override
	public MemberDTO getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public void updateMember(MemberDTO memberDTO) {
		memberDAO.updateMember(memberDTO);
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		return memberDAO.userCheck(memberDTO);
	}
	
	
	
	
	
}
