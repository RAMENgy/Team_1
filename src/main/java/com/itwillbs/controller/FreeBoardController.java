package com.itwillbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FreeBoardController {
	
	/*
	 * Mapping 주소 : 주소 창 입력 시 Mapping 시킬 주소
	 * return 주소 : 실제 경로 주소
	 */
	
	
	@RequestMapping(value = "/freeboard", method = RequestMethod.GET)
	public String freeBoard(HttpSession session, Model model) {
		return "freeboard/freeboard";
	}
	
}
