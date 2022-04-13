package com.itwillbs.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.FBCommentDTO;
import com.itwillbs.domain.FreeBoardDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.FreeBoardService;

@Controller
public class FreeBoardController {
	
	@Inject
	private FreeBoardService freeBoardService;
	
	@RequestMapping(value = "/free/board", method = RequestMethod.GET)
	public String freeBoard(HttpServletRequest request, Model model) {
		
		int pageSize=10;
		
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
		
		List<FBCommentDTO> CommentList=freeBoardService.getCommentList(intId);
		
		model.addAttribute("CommentList", CommentList);
		
		return "freeboard/fcontent";
	}
	
	@RequestMapping(value = "/free/write", method = RequestMethod.GET)
	public String freeWrite() {
		return "freeboard/fwrite";
	}
	
	@RequestMapping(value = "/free/writePro", method = RequestMethod.POST)
	public String freeWritePro(FreeBoardDTO FBDTO){
		FBDTO.setId(freeBoardService.getMaxNum(true)+1);
		FBDTO.setDate(new Timestamp(System.currentTimeMillis()));
		
		freeBoardService.writeBoard(FBDTO);
		return "redirect:/free/board";
	}
	
	@RequestMapping(value = "/free/update", method = RequestMethod.GET)
	public String freeUpdate(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		FreeBoardDTO FBDTO = freeBoardService.getBoard(id);
		model.addAttribute("FBDTO", FBDTO);
		return "freeboard/fupdate";
	}
	
	@RequestMapping(value = "/free/updatePro", method = RequestMethod.POST)
	public String freeUpdatePro(FreeBoardDTO FBDTO){
		freeBoardService.updateBoard(FBDTO);
		return "redirect:/free/board";
	}
	
	@RequestMapping(value = "/free/delete", method = RequestMethod.GET)
	public String freeDelete(HttpServletRequest request, HttpSession session) {
		// 세션 본인 판별 => 권한 지급
		int id = Integer.parseInt(request.getParameter("id"));
		freeBoardService.deleteBoard(id);
		return "redirect:/free/board";
	}
	
	/* 아래서 부터는 Comment */
	
	@RequestMapping(value = "/free/writeComment", method = RequestMethod.POST)
	public String freeWriteComment(FBCommentDTO FBCDTO, HttpSession session){
		FBCDTO.setDate(new Timestamp(System.currentTimeMillis()));
		FBCDTO.setMember_id((int) session.getAttribute("id"));
		FBCDTO.setId(freeBoardService.getMaxNum(false)+1);
		freeBoardService.writeComment(FBCDTO);
		return "redirect:/free/content?id="+FBCDTO.getFreeboard_id();
	}
	
}
