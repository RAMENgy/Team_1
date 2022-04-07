package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@RestController
public class AjaxController {

	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="/order/orderinfojson", method=RequestMethod.GET)
	public ResponseEntity<MemberDTO> orderinfojason(HttpSession session){
		
		String userid = (String)session.getAttribute("userid");
		MemberDTO memberDTO = memberService.getMember(userid);
		
		
		ResponseEntity<MemberDTO> entity = new ResponseEntity<MemberDTO>(memberDTO, HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value = "/member/idcheck", method = RequestMethod.GET)
	public ResponseEntity<String> testidcheck(HttpServletRequest request){
		String result="";
		String userid=request.getParameter("userid");
		MemberDTO memberDTO=memberService.getMember(userid);
		if(memberDTO!=null) {
			//아이디 있음 => 아이디 중복
			result="iddup";
		}else {
			//아이디 없음 => 아이디 사용가능
			result="idok";
		}
		ResponseEntity<String> entity=new ResponseEntity<String>(result, HttpStatus.OK);
		
		return entity;
	}
}
