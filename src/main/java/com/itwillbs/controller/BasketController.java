package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.ProductDTO;
import com.itwillbs.service.BasketService;

@Controller
public class BasketController {

	@Inject
	private BasketService basketService;
	
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public String basketList(Model model, HttpSession session) {
		
		System.out.println("BasketController basketList()");
		
		String id = (String)session.getAttribute("userid");
		
		if(id != null) {
			List<ProductDTO> basketList = basketService.basketList(id);
			
			model.addAttribute("basketList", basketList);
		}
		
		return "basket";
	}

	

}
