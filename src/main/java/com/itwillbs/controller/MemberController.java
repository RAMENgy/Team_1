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

	@RequestMapping(value = "/main/main", method = RequestMethod.GET)
	public String main(HttpSession session, Model model) {
		
		
		return "main/index";
	}
	
	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	
	@RequestMapping(value = "/member/joinPro", method = RequestMethod.POST)
	public String joinPro(MemberDTO memberDTO, HttpSession session) {
		memberService.insertMember(memberDTO);
		
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO memberDTO, HttpSession session) {
		MemberDTO ckDTO = memberService.userCheck(memberDTO);
		
		if (ckDTO!=null) {
			session.setAttribute("userid", memberDTO.getUserid());
			return "redirect:/main/main";
		} else {
			return "member/msg";
		}
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/main";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		
		System.out.println("Test");
		String userid = (String) session.getAttribute("userid");
		MemberDTO memberDTO = memberService.getMember(userid);
		model.addAttribute("memberDTO", memberDTO);
		
		return "member/update";
	}
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO) {
		System.out.println("객체 : " + memberDTO);
		System.out.println("아이디 : " + memberDTO.getUserid());
		System.out.println("pw : " + memberDTO.getPassword());
		System.out.println("이름 : " + memberDTO.getName());
		MemberDTO ckDTO = memberService.userCheck(memberDTO);

		if (ckDTO!=null) {
			memberService.updateMember(memberDTO);
			return "redirect:/main/main";
		} else {
			return "member/msg";
		}
	}
	
	
	
}
