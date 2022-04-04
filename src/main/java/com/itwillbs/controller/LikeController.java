package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.LikeDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.LikeService;
import com.itwillbs.service.MemberService;

@Controller
public class LikeController {
	
	
	@Inject
	private LikeService likeService;
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "like/likelist", method = RequestMethod.GET)
	public String likelist(Model model, HttpSession session,HttpServletRequest request) {
		
		System.out.println("LikeBoardController likeList()");
		String userid = (String)session.getAttribute("userid");
		MemberDTO ckDTO = memberService.getMember(userid);
		
		
		if(ckDTO != null) {
		int member_id = ckDTO.getId();
		System.out.println("회원번호 : "+member_id);
		// 한화면에 보여줄 글개수 설정
//		int pageSize=15;
//		
//		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
//		String pageNum=request.getParameter("pageNum");
//		if(pageNum==null) {
//			pageNum="1";
//		}
//		
//		
//		PageDTO pageDTO=new PageDTO();
//		pageDTO.setPageSize(pageSize);
//		pageDTO.setPageNum(pageNum);
		
		List<LikeDTO> boardList=likeService.getBoardList(member_id);
		
		//전체 글개수 구하기 => 디비에서 가져오기
		//int  리턴할형  getBoardCount() 메서드 정의
		//select count(*) from board
		// int count=bDAO.getBoardCount();
//		int count=likeService.getBoardCount();
//		
//		int currentPage=Integer.parseInt(pageNum);
//		int pageBlock=10;
//		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
//		int endPage=startPage+pageBlock-1;
//		int pageCount=count / pageSize +  (count % pageSize == 0 ?0:1);
//		if(endPage > pageCount){
//			endPage = pageCount;
//		}
//		
//		pageDTO.setCount(count);
//		pageDTO.setPageBlock(pageBlock);
//		pageDTO.setStartPage(startPage);
//		pageDTO.setEndPage(endPage);
//		pageDTO.setPageCount(pageCount);
		
		// 디비에서 가져온 글을 model 담아서 notice.jsp 전달
		model.addAttribute("boardList", boardList);
//		model.addAttribute("pageDTO", pageDTO);
		
		// /WEB-INF/views/center/notice.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "like/likeList";
		
		
			
			
		} else {
			
			return "needLoginMsg";
		}
		
		
	}
	
	@RequestMapping(value = "/like/deleteLikeList", method = RequestMethod.GET)
	public String deletelike(HttpServletRequest request, HttpSession session) {
		System.out.println("LikeController deletelike ");
		int id=Integer.parseInt(request.getParameter("id"));
		LikeDTO lDTO = new LikeDTO();
		lDTO.setId(id);
		System.out.println("삭제되는 좋아요 게시글 번호"+id);
		
		likeService.deleteBoard(id);
		
		return "redirect:/like/likelist";
	}
	
}
