package com.itwillbs.service;

import com.itwillbs.domain.MemberDTO;

public interface MemberService {
	
	public MemberDTO getMember(String id); // test
	public void updateMember(MemberDTO memberDTO);
}
