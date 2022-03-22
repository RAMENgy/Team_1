package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;



@Controller
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	
	
	
	
	
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		
		System.out.println("Test");
		//String id = (String) session.getAttribute("id");
		String id = "asdasd";
		MemberDTO memberDTO = memberService.getMember(id);
		model.addAttribute("memberDTO", memberDTO);
		
		return "member/update";
	}
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO, HttpSession session) {
		
		
		System.out.println("객체 : " + memberDTO);
		System.out.println("아이디 : " + memberDTO.getUserid());
		System.out.println("pw : " + memberDTO.getPassword());
		System.out.println("이름 : " + memberDTO.getName());
		
		
		System.out.println("MemberController updatePro()");
		MemberDTO ckDTO = memberService.userCheck(memberDTO);

		if (ckDTO!=null) {
			memberService.updateMember(memberDTO);
			return "redirect:/main/main";
		} else {
			return "member/msg";
		}
	}
}

