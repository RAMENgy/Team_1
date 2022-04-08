package com.itwillbs.controller;


import java.util.List;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.dao.FoodDAO;
import com.itwillbs.domain.FoodDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.FoodService;


@Controller
public class foodController {
	@Inject
	private FoodService foodService;
	
	@RequestMapping(value = "/food/list", method = RequestMethod.GET)
	public String food(HttpServletRequest request, Model model) {
		
		int pageSize=12;
		
		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		
		List<FoodDTO> foodList=foodService.foodlist(pageDTO);
		
		//전체 글개수 구하기 => 디비에서 가져오기
		//int  리턴할형  getBoardCount() 메서드 정의
		//select count(*) from board
		// int count=bDAO.getBoardCount();
		int count=foodService.getFoodCount();
		
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
	
		System.out.println(pageDTO.getStartPage());
		System.out.println(pageDTO.getEndPage());

		model.addAttribute("pageDTO", pageDTO);
		
		model.addAttribute("foodList", foodList);
		return "food/shop";
	}
	@RequestMapping(value = "/meat/list", method = RequestMethod.GET)
	public String meat(HttpServletRequest request, Model model) {
		int pageSize=12;
		
		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		
		List<FoodDTO> meatlist=foodService.meatlist(pageDTO);
		
		//전체 글개수 구하기 => 디비에서 가져오기
		//int  리턴할형  getBoardCount() 메서드 정의
		//select count(*) from board
		// int count=bDAO.getBoardCount();
		int count=foodService.getmeatCount();
		
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

		model.addAttribute("pageDTO", pageDTO);
		
		model.addAttribute("meatList", meatlist);
		return "food/meat";
	}
	@RequestMapping(value = "/vegetable/list", method = RequestMethod.GET)
	public String vegetable(HttpServletRequest request, Model model) {
		int pageSize=12;
		
		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		
		List<FoodDTO> vegetablelist=foodService.vegetablelist(pageDTO);
		
		//전체 글개수 구하기 => 디비에서 가져오기
		//int  리턴할형  getBoardCount() 메서드 정의
		//select count(*) from board
		// int count=bDAO.getBoardCount();
		int count=foodService.getvegetableCount();
		
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
	
		model.addAttribute("pageDTO", pageDTO);
		
		model.addAttribute("vegetableList", vegetablelist);
		return "food/vegetable";
	}
	@RequestMapping(value = "/fruit/list", method = RequestMethod.GET)
	public String fruit(HttpServletRequest request, Model model) {
		int pageSize=12;
		
		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		
		List<FoodDTO> fruitlist=foodService.fruitlist(pageDTO);
		
		//전체 글개수 구하기 => 디비에서 가져오기
		//int  리턴할형  getBoardCount() 메서드 정의
		//select count(*) from board
		// int count=bDAO.getBoardCount();
		int count=foodService.getfruitCount();
		
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
	
		model.addAttribute("pageDTO", pageDTO);
		
		model.addAttribute("fruitList", fruitlist);
		return "food/fruit";
	}
	
	
	@RequestMapping(value = "/food/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, Model model) {
		String search = request.getParameter("search-food");
		String search2 = "%"+search+"%";
		int pageSize=12;
		
		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setSearch(search2);
		List<FoodDTO> foodList=foodService.foodlistSearch(pageDTO);
		
		//전체 글개수 구하기 => 디비에서 가져오기
		//int  리턴할형  getBoardCount() 메서드 정의
		//select count(*) from board
		// int count=bDAO.getBoardCount();
		int count=foodService.getFoodCountSearch(pageDTO);
		
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
	
		model.addAttribute("pageDTO", pageDTO);
		
		model.addAttribute("foodList", foodList);
		return "food/shopsearch";
	}
	@RequestMapping(value = "/meat/search", method = RequestMethod.GET)
	public String meatsearch(HttpServletRequest request, Model model) {
		String search = request.getParameter("search-food");
		String search2 = "%"+search+"%";
		int pageSize=12;
		
		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setSearch(search2);
		List<FoodDTO> foodList=foodService.meatlistSearch(pageDTO);
		
		//전체 글개수 구하기 => 디비에서 가져오기
		//int  리턴할형  getBoardCount() 메서드 정의
		//select count(*) from board
		// int count=bDAO.getBoardCount();
		int count=foodService.getmeatCountSearch(pageDTO);
		
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
	
		model.addAttribute("pageDTO", pageDTO);
		
		model.addAttribute("foodList", foodList);
		return "food/meatsearch";
	}
	@RequestMapping(value = "/vegetable/search", method = RequestMethod.GET)
	public String vegetablesearch(HttpServletRequest request, Model model) {
		String search = request.getParameter("search-food");
		String search2 = "%"+search+"%";
		int pageSize=12;
		
		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setSearch(search2);
		List<FoodDTO> foodList=foodService.vegetablelistSearch(pageDTO);
		
		//전체 글개수 구하기 => 디비에서 가져오기
		//int  리턴할형  getBoardCount() 메서드 정의
		//select count(*) from board
		// int count=bDAO.getBoardCount();
		int count=foodService.getvegetableCountSearch(pageDTO);
		
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
	
		model.addAttribute("pageDTO", pageDTO);
		
		model.addAttribute("foodList", foodList);
		return "food/vegetablesearch";
	}
	@RequestMapping(value = "/fruit/search", method = RequestMethod.GET)
	public String fruitsearch(HttpServletRequest request, Model model) {
		String search = request.getParameter("search-food");
		String search2 = "%"+search+"%";
		int pageSize=12;
		
		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setSearch(search2);
		List<FoodDTO> foodList=foodService.fruitlistSearch(pageDTO);
		
		//전체 글개수 구하기 => 디비에서 가져오기
		//int  리턴할형  getBoardCount() 메서드 정의
		//select count(*) from board
		// int count=bDAO.getBoardCount();
		int count=foodService.getfruitCountSearch(pageDTO);
		
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
	
		model.addAttribute("pageDTO", pageDTO);
		
		model.addAttribute("foodList", foodList);
		return "food/meatsearch";
	
	}
	
	@RequestMapping(value = "/food/content", method = RequestMethod.GET)
	public String content(HttpServletRequest request, Model model) {
		int id=Integer.parseInt(request.getParameter("id"));
		
		// num에 대한 글 가져오기
		FoodDTO foodDTO=foodService.getfood(id);
		
		// 디비에서 가져온 글을 model 담아서 content.jsp 전달
		model.addAttribute("foodDTO", foodDTO);
		
		// /WEB-INF/views/center/content.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "food/content";
	}
}
