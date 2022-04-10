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
	
	@RequestMapping(value = "/free/board", method = RequestMethod.GET)
	public String freeBoard(HttpServletRequest request, Model model) {
		
		int pageSize=10;
		
		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum=request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum="1";
		}
		
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		
		List<FreeBoardDTO> boardList=freeBoardService.getBoardList(pageDTO);
		
		int count=freeBoardService.getBoardCount();
		
		int currentPage=Integer.parseInt(pageNum);
		int pageBlock=5;
		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int pageCount=count / pageSize +  (count % pageSize == 0 ?0:1);
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		
		// 디비에서 가져온 글을 model 담아서 notice.jsp 전달
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);
		
		return "freeboard/freeboard";
	}
	
	@RequestMapping(value = "/free/content", method = RequestMethod.GET)
	public String freeContent(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		if (id == null) {
			id = "1";
		}
		int intId = Integer.parseInt(id);
		FreeBoardDTO FBDTO = freeBoardService.getBoard(intId);
		
		model.addAttribute("FBDTO", FBDTO);
		
		
		return "freeboard/fcontent";
	}
	
	@RequestMapping(value = "/free/write", method = RequestMethod.GET)
	public String freeWrite(HttpServletRequest request, Model model) {
		
		
		
		return "freeboard/fwrite";
	}
	
	
}
