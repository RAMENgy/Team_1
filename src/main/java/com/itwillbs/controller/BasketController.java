package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.ProductDTO;
import com.itwillbs.service.BasketService;
import com.itwillbs.service.MemberService;

@Controller
public class BasketController {

	@Inject
	private BasketService basketService;
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public String basketList(Model model, HttpSession session) {
		
		System.out.println("BasketController basketList()");
		
		String userid = (String)session.getAttribute("userid");
		MemberDTO ckDTO = memberService.getMember(userid);
		
		
		if(ckDTO != null) {
			
			int member_id = ckDTO.getId();
			
			List<BasketDTO> basketList = basketService.basketList(member_id);
			
			model.addAttribute("basketList", basketList);
			
			return "basket";
			
		} else {
			
			return "redirect:/main/main";
		}
		
		
	}

	

}
