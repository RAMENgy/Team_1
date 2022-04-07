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
		LikeDTO lDTO = new LikeDTO();
		
		if(ckDTO != null) {
		int member_id = ckDTO.getId();
		System.out.println("회원번호 : "+member_id);
		lDTO.setMember_id(ckDTO.getId());
		// likelist에 좋아요한 id값 = 현재 접속중인 id
		
		// 내가 좋아요 누른 항목 갯수 찾기
		session.setAttribute("likecount", likeService.getBoardCount(ckDTO.getId()));
		
		// likecount 세션값 재설정
		
		System.out.println("좋아요 수 : "+likeService.getBoardCount(lDTO.getMember_id()));
		
		List<LikeDTO> boardList=likeService.getBoardList(member_id);
		
		// 디비에서 가져온 글을 model 담아서 notice.jsp 전달
		model.addAttribute("boardList", boardList);
		
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
