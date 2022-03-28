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
public class LikeController {
	
		
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "like/likelist", method = RequestMethod.GET)
	public String likelist(Model model, HttpSession session) {
		
		System.out.println("LikeBoardController likeList()");
		
		String userid = (String)session.getAttribute("userid");
		MemberDTO ckDTO = memberService.getMember(userid);
		
		
		if(ckDTO != null) {
			
			return "like/likeList";
			
		} else {
			
			return "needLoginMsg";
		}
		
		
	}
}
