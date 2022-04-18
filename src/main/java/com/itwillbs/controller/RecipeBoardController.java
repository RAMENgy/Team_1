package com.itwillbs.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itwillbs.domain.RecipeBoardDTO;
import com.itwillbs.domain.FBCommentDTO;
import com.itwillbs.domain.FoodDTO;
import com.itwillbs.domain.FreeBoardDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.RBCommentDTO;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.RecipeBoardService;

@Controller
public class RecipeBoardController {
	
	// RecipeBoardService recipeboardService=new RecipeBoardServiceImpl();
	@Inject
	private RecipeBoardService recipeBoardService;
	
	@Inject
	private MemberService memberService;
	
	//파일경로 xml 받아옴
	@Resource(name = "recipeUploadPath")
	private String recipeUploadPath;
	
	//	가상주소 http://localhost:8080/github/recipeboard/write
	@RequestMapping(value = "/recipeboard/write", method = RequestMethod.GET)
	public String write() {
		System.out.println("RecipeBoardController write() ");
		return "recipeboard/write";
	}
	
	@RequestMapping(value = "/recipeboard/writePro", method = RequestMethod.POST)
	public String writePro(MemberDTO memberDTO,HttpServletRequest request,HttpSession session, @RequestParam("file") List<MultipartFile> file) throws Exception{
		System.out.println("RecipeBoardController writePro() ");
		
		// 제목, 내용 받아오기
		RecipeBoardDTO rbDTO = new RecipeBoardDTO();
		rbDTO.setSubject(request.getParameter("subject"));
		rbDTO.setContent(request.getParameter("content"));
		
		String userid = (String)session.getAttribute("userid");
		MemberDTO mDTO = memberService.getMember(userid);
		
		session.setAttribute("point", mDTO.getPoint()+10);
		
		// 다중 이미지 업로드 구현
		String files = "";
		for(int i=0; i<file.size(); i++) {
			UUID uid=UUID.randomUUID();
			String fileName=uid.toString()+"_"+file.get(i).getOriginalFilename();
			File uploadfile=new File(recipeUploadPath, fileName);
			FileCopyUtils.copy(file.get(i).getBytes(), uploadfile);
			files += fileName;
		}
		
		rbDTO.setImg(files);
		recipeBoardService.writeBoard(rbDTO);
		
		return "redirect:/recipeboard/list";
		
	}
	
	
	//	가상주소 http://localhost:8080/github/recipeboard/list
	//	가상주소 http://localhost:8080/github/recipeboard/list?pageNum=3
	@RequestMapping(value = "/recipeboard/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		System.out.println("RecipeBoardController list()");
		int pageSize=5;
		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		
		List<RecipeBoardDTO> recipeboardList = recipeBoardService.getBoardList(pageDTO);
		
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
		
		model.addAttribute("recipeboardList", recipeboardList);
		model.addAttribute("pageDTO", pageDTO);
		
		return "recipeboard/list";
	}
	
	// 가상주소 http://localhost:8080/github/recipeboard/content?id=1
	@RequestMapping(value = "/recipeboard/content", method = RequestMethod.GET)
	public String content(HttpServletRequest request, Model model) {
		System.out.println("RecipeBoardController content() ");
		
		String id = request.getParameter("id");
		if (id == null) {
			id = "1";
		}
		int intId = Integer.parseInt(id);
		recipeBoardService.updateReadcount(intId);
		RecipeBoardDTO rbDTO = recipeBoardService.getBoard(intId);
		model.addAttribute("rbDTO", rbDTO);
		
		List<RBCommentDTO> CommentList=recipeBoardService.getCommentList(intId);
		
		model.addAttribute("CommentList", CommentList);
		return "recipeboard/content";
	}	
	
	// 가상주소 http://localhost:8080/github/recipeboard/update?id=1
	@RequestMapping(value = "/recipeboard/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		System.out.println("RecipeBoardController update() ");
		int id=Integer.parseInt(request.getParameter("id"));
			
		// id에 대한 글 가져오기
		RecipeBoardDTO recipeBoardDTO=recipeBoardService.getBoard(id);
			
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
	
	// 가상주소 http://localhost:8080/github/recipeboard/delete?id=1
	@RequestMapping(value = "/recipeboard/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		System.out.println("RecipeBoardController delete() ");
		int id=Integer.parseInt(request.getParameter("id"));
		
		// id에 대한 글 삭제
		recipeBoardService.deleteBoard(id);
		
		// 가상주소 로그인주소 이동 /board/list (주소줄에 주소가 바뀌면서 이동)
		// 	response.sendRedirect("/board/list");
		return "redirect:/recipeboard/list";
	}

	// 가상주소 http://localhost:8080/github/recipeboard/search
	@RequestMapping(value = "/recipeboard/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, Model model) {
		System.out.println("RecipeBoardController search() ");
		//검색어 가져오기
		String search = request.getParameter("search");
		String search2 = "%"+search+"%";
		int pageSize=10;
		
		
		String pageNum=request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum="1";
		}
		
		
		PageDTO pageDTO=new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setSearch(search2);
		List<RecipeBoardDTO> recipeboardList=recipeBoardService.getBoardListSearch(pageDTO);
		
		int count=recipeBoardService.getBoardCount();
		
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
		
		System.out.println("검색어 : "+search2);
		
		model.addAttribute("recipeboardList", recipeboardList);
		model.addAttribute("pageDTO", pageDTO);
		
		// /WEB-INF/views/recipeboard/listSearch.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "recipeboard/list";
	}
	
	@RequestMapping(value = "/recipeboard/bestrecipe", method = RequestMethod.GET)
	public String bestrecipe(Model model) {
		int id = recipeBoardService.getMaxLike();
		RecipeBoardDTO rbDTO=recipeBoardService.getBoard(id);
		
		model.addAttribute("rbDTO", rbDTO);;
		System.out.println("글번호"+id);
		
		return "recipeboard/content";
	}
	
	@RequestMapping(value = "/recipeboard/writeComment", method = RequestMethod.POST)
	public String recipeBoardWriteComment(RBCommentDTO RBCDTO, HttpSession session){
		RBCDTO.setDate(new Timestamp(System.currentTimeMillis()));
		RBCDTO.setMember_id((int) session.getAttribute("id"));
		RBCDTO.setId(recipeBoardService.getMaxNum(false)+1);
		recipeBoardService.writeComment(RBCDTO);
		return "redirect:/recipeboard/content?id="+RBCDTO.getRecipe_board_id();
	}
	
	@RequestMapping(value = "/recipeboard/deleteComment", method = RequestMethod.GET)
	public String recipeBoardDeleteComment(HttpServletRequest request, HttpSession session) {
		int commentId = Integer.parseInt(request.getParameter("id"));
		int pageId = Integer.parseInt(request.getParameter("page"));
		
		recipeBoardService.deleteComment(commentId);
		
		
		// current page 
		return "redirect:/recipeboard/content?id="+pageId;
	}
	
	
}
