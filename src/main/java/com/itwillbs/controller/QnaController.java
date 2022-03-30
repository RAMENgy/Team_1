package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.QnaDTO;
import com.itwillbs.service.QnaService;

@Controller
public class QnaController {
	
	@Inject 
	QnaService qnaService;
	
	@RequestMapping(value = "/qna/qnalist", method = RequestMethod.GET)
	public String qnalist(HttpServletRequest request, Model model) {
		
		System.out.println("QnaController qnalist() ");
		// 한화면에 보여줄 글개수 설정
		int pageSize=15;
		
		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		
		List<QnaDTO> boardList=qnaService.getBoardList(pageDTO);
		
		int count=qnaService.getBoardCount();
		
		int currentPage=Integer.parseInt(pageNum);
		int pageBlock=10;
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
		
		return "qna/qnaList";
	}
	
	
	
}	
