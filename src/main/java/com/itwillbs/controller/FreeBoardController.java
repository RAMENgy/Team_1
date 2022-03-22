package com.itwillbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FreeBoardController {
	
	@RequestMapping(value = "/freeboard/freeboard", method = RequestMethod.GET)
	public String freeBoard(HttpSession session, Model model) {
		return "freeboard/freeboard";
	}
	
}
