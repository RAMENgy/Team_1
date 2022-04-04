package com.itwillbs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		
		Map<String, Object> map=new HashMap<>();
		String userid = (String)session.getAttribute("userid");
		MemberDTO memberDTO = memberService.getMember(userid);
				
		model.addAttribute("memberDTO", memberDTO); 
		
		if(memberDTO != null) {
			
			int member_id = memberDTO.getId();
			
			List<BasketDTO> basketList = basketService.basketList(member_id);
			model.addAttribute("basketList", basketList);
			
			int sumMoney = basketService.sumMoney(member_id);
			map.put("sumMoney", sumMoney);
			model.addAttribute("map", map);
			
			return "order/orderinfo";
			
		} else {
			
			return "order/msg";
		}
		
	}

}
