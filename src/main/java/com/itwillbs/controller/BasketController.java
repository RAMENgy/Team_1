package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.service.BasketService;

@Controller
public class BasketController {

	@Inject
	private BasketService basketService;
	
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public String basketList(Model model) {
		
		System.out.println("BasketController basketList()");
		
		List<BasketDTO> basketList = basketService.basketList();
		
		model.addAttribute("basketList", basketList);
		return "basket";
	}

	

}
