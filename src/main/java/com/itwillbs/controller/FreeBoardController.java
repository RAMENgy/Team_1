package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.FreeBoardDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.FreeBoardService;

@Controller
public class FreeBoardController {
	
	/*
	 * Mapping 주소 : 주소 창 입력 시 Mapping 시킬 주소
	 * return 주소 : 실제 경로 주소
	 */
	
	@Inject
	private FreeBoardService freeBoardService;
	
	@RequestMapping(value = "/freeboard", method = RequestMethod.GET)
	public String freeBoard(HttpServletRequest request, Model model) {
		
		String pageNum	= request.getParameter("pageNum");
		PageDTO pageDTO	= getPageParameter(pageNum);
		
		
		List<FreeBoardDTO> boardList = freeBoardService.getBoardList(pageDTO);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);
		
		return "freeboard/freeboard";
	}
	
	private PageDTO getPageParameter(String pageNum) {
		
		PageDTO pDTO = new PageDTO();
		
		if(pageNum==null) {
			pageNum="1";
		}
		
		int pageSize	= 15;
		int pageBlock	= 10;
		int currentPage	= Integer.parseInt(pageNum);
		int startPage	= (currentPage-1) / pageBlock * pageBlock+1;
		int endPage		= startPage + pageBlock - 1;
//		int count		= bDAO.getBoardCount();
//		int pageCount	= count / pageSize +  (count % pageSize == 0 ? 0 : 1);
		
//		if(endPage > pageCount){
//			endPage = pageCount;
//		}
		
		
		pDTO.setPageSize(pageSize);
		pDTO.setPageNum(pageNum);
		pDTO.setCurrentPage(currentPage);
		return pDTO;
	}
	
}
