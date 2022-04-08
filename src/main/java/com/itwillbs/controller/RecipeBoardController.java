package com.itwillbs.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.itwillbs.domain.RecipeBoardDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.RecipeBoardService;

@Controller
public class RecipeBoardController {
	
	// RecipeBoardService recipeboardService=new RecipeBoardServiceImpl();
	@Inject
	private RecipeBoardService recipeBoardService;
	
	//파일경로 xml 받아옴
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	//	가상주소 http://localhost:8080/github/recipeboard/write
	@RequestMapping(value = "/recipeboard/write", method = RequestMethod.GET)
	public String write() {
		System.out.println("RecipeBoardController write() ");
		return "recipeboard/write";
	}
	
	@RequestMapping(value = "/recipeboard/writePro", method = RequestMethod.POST)
	public String writePro(HttpServletRequest request, MultipartFile file) throws Exception {
		System.out.println("RecipeBoardController writePro() ");
		//파일업로드 폼에서 RecipeBoardDTO 자동으로 못가져옴
		RecipeBoardDTO rbDTO=new RecipeBoardDTO();
		rbDTO.setMember_id(Integer.parseInt(request.getParameter("member_id")));
		rbDTO.setSubject(request.getParameter("subject"));
		rbDTO.setContent(request.getParameter("content"));

		//실제 파일 file.getBytes();  =>파일이름변경 => upload폴더 복사
		// 랜덤문자_파일이름  파일이름변경
		UUID uid=UUID.randomUUID();
		String fileName=uid.toString()+"_"+file.getOriginalFilename();
		// 파일 복사 => upload폴더 파일이름
		File uploadfile=new File(uploadPath,fileName);
		FileCopyUtils.copy(file.getBytes(), uploadfile);
		
		rbDTO.setImg(fileName);
		//디비작업
		// 객체생성
		//BoardService boardService=new BoardServiceImpl();
		//메서드 호출
		recipeBoardService.writeBoard(rbDTO);
		
		// 가상주소 로그인주소 이동 /board/list (주소줄에 주소가 바뀌면서 이동)
		// 	response.sendRedirect("/recipeboard/list");
		
		return "redirect:/recipeboard/list";
		
	}
	
	//	가상주소 http://localhost:8080/github/recipeboard/list
	//	가상주소 http://localhost:8080/github/recipeboard/list?pageNum=3
	@RequestMapping(value = "/recipeboard/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		System.out.println("RecipeBoardController list()");
		int pageSize=15;
		
		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		
		List<RecipeBoardDTO> boardList = recipeBoardService.getBoardList(pageDTO);
		
		//전체 글개수 구하기 => 디비에서 가져오기
		//int  리턴할형  getBoardCount() 메서드 정의
		//select count(*) from board
		// int count=bDAO.getBoardCount();
		int count=recipeBoardService.getBoardCount();
				
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
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);
		
		return "recipeboard/list";
	}
	
	// 가상주소 http://localhost:8080/github/recipeboard/content?num=1
	@RequestMapping(value = "/recipeboard/content", method = RequestMethod.GET)
	public String content(HttpServletRequest request, Model model) {
		System.out.println("RecipeBoardController content() ");
		int num=Integer.parseInt(request.getParameter("member_id"));
		//조회수 증가 update board set readcount=readcount+1 where member_id=?
		recipeBoardService.updateReadcount(num);
		
		// num에 대한 글 가져오기
		RecipeBoardDTO recipeBoardDTO=recipeBoardService.getBoard(num);
			
		// 디비에서 가져온 글을 model 담아서 content.jsp 전달
		model.addAttribute("recipeBoardDTO", recipeBoardDTO);
			
		// /WEB-INF/views/center/content.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "recipeboard/content";
	}	
	
	// 가상주소 http://localhost:8080/github/recipeboard/update?num=1
	@RequestMapping(value = "/recipeboard/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		System.out.println("RecipeBoardController update() ");
		int num=Integer.parseInt(request.getParameter("member_id"));
			
		// num에 대한 글 가져오기
		RecipeBoardDTO recipeBoardDTO=recipeBoardService.getBoard(num);
			
		// 디비에서 가져온 글을 model 담아서 update.jsp 전달
		model.addAttribute("recipeBoardDTO", recipeBoardDTO);
			
		// /WEB-INF/views/center/update.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "recipeboard/update";
	}	
	
	// 가상주소 http://localhost:8080/github/recipeboard/updatePro
	@RequestMapping(value = "/recipeboard/updatePro", method = RequestMethod.POST)
		public String updatePro(RecipeBoardDTO recipeBoardDTO) {
		System.out.println("RecipeBoardController updatePro() ");
		//디비작업
		// 객체생성
		//RecipeBoardService recipeBoardService=new RecipeBoardServiceImpl();
		//메서드 호출
		recipeBoardService.updateBoard(recipeBoardDTO);
		
		// 가상주소 로그인주소 이동 /recipeboard/list (주소줄에 주소가 바뀌면서 이동)
		// 	response.sendRedirect("/recipeboard/list");
		return "redirect:/recipeboard/list";
	}	
	
	// 가상주소 http://localhost:8080/github/recipeboard/delete?=num=1
	@RequestMapping(value = "/recipeboard/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		System.out.println("RecipeBoardController delete() ");
		int num=Integer.parseInt(request.getParameter("member_id"));
		
		// num에 대한 글 삭제
		recipeBoardService.deleteBoard(num);
		
		// 가상주소 로그인주소 이동 /board/list (주소줄에 주소가 바뀌면서 이동)
		// 	response.sendRedirect("/board/list");
		return "redirect:/recipeboard/list";
	}

	// 가상주소 http://localhost:8080/github/recipeboard/search
	@RequestMapping(value = "/recipeboard/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, Model model) {
		System.out.println("RecipeBoardController search() ");
		//검색어 가져오기
		String search=request.getParameter("search");
		String search2="%"+search+"%";
		
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
		pageDTO.setSearch(search2);
		
		List<RecipeBoardDTO> boardList=recipeBoardService.getBoardListSearch(pageDTO);
		
		//전체 글개수 구하기 => 디비에서 가져오기
		//int  리턴할형  getBoardCount() 메서드 정의
		//select count(*) from board
		// int count=bDAO.getBoardCount();
		int count=recipeBoardService.getBoardCountSearch(pageDTO);
		
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
		
		//검색어
		pageDTO.setSearch(search);
		
		// 디비에서 가져온 글을 model 담아서 notice.jsp 전달
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);
		
		// /WEB-INF/views/recipeboard/listSearch.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "recipeboard/listSearch";
	}	
	
}
