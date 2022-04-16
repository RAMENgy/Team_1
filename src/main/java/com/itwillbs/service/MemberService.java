package com.itwillbs.service;

import com.itwillbs.domain.MemberDTO;

public interface MemberService {
	
	public MemberDTO getMember(String userid); // test
	public void updateMember(MemberDTO memberDTO);
	public MemberDTO userCheck(MemberDTO memberDTO);
	public void insertMember(MemberDTO memberDTO);
	public void deleteMember(int id);
}
