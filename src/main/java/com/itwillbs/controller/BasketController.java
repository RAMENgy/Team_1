package com.itwillbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasketController {


	
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public String basket(Model model) {
		
			
		return "basket";
	}

	

}
