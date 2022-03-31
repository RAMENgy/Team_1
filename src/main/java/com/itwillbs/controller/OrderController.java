package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.BasketService;
import com.itwillbs.service.MemberService;

@Controller
public class OrderController {
	
	@Inject
	private BasketService basketService;
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="/order", method = RequestMethod.GET)
	public String order(HttpSession session, Model model) {
		
		String userid = (String)session.getAttribute("userid");
		MemberDTO memberDTO = memberService.getMember(userid);
				
		model.addAttribute("memberDTO", memberDTO); 
		
		int member_id = memberDTO.getId();
		
		List<BasketDTO> basketList = basketService.basketList(member_id);
		
		model.addAttribute("basketList", basketList);
		
		return "order/orderinfo";
	}

}
