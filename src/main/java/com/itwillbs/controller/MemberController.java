package com.itwillbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;



@Controller
public class MemberController {
	
	
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		
		System.out.println("MemberController update()");
		
		String id = (String) session.getAttribute("id");
		
		//MemberDTO memberDTO = memberService.getMember(id);
		//model.addAttribute("memberDTO", memberDTO);
		
		return "member/update";
		
	}
}
