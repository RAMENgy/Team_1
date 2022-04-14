package com.itwillbs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.LikeDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.BasketService;
import com.itwillbs.service.LikeService;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {

	@Inject
	private LikeService likeService;

	@Inject
	private MemberService memberService;
	
	@Inject
	private BasketService basketService;

	
	@RequestMapping(value = "/main/main", method = RequestMethod.GET) public
	String main(HttpSession session, Model model) {
		
		//장바구니 목록
		Map<String, Object> map=new HashMap<>();
		String userid = (String)session.getAttribute("userid");
		MemberDTO ckDTO = memberService.getMember(userid);
		
		if(ckDTO != null) {
			
			int member_id = ckDTO.getId();
			
			List<BasketDTO> basketList = basketService.basketList(member_id);
			
			session.setAttribute("basketList", basketList);
			
			int sumMoney = basketService.sumMoney(member_id);
			map.put("sumMoney", sumMoney);
			model.addAttribute("map", map);
			
			return "main/index";
			
		} else {

			return "main/index";
		
		}
	  
	}
	 

	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public String join() {
		return "member/join";
	}

	@RequestMapping(value = "/member/joinPro", method = RequestMethod.POST)
	public String joinPro(MemberDTO memberDTO, HttpSession session) {
		memberService.insertMember(memberDTO);

		return "redirect:/member/login";
	}

	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO memberDTO, HttpSession session) {
		MemberDTO ckDTO = memberService.userCheck(memberDTO);
		LikeDTO lDTO = new LikeDTO();
		if (ckDTO != null) {
			session.setAttribute("id", ckDTO.getId());
			session.setAttribute("userid", ckDTO.getUserid());
			session.setAttribute("name", ckDTO.getName());
			lDTO.setMember_id(ckDTO.getId());
			// 내가 좋아요 누른 항목 갯수 찾기
			session.setAttribute("likecount", likeService.getBoardCount(ckDTO.getId()));
			// 세션명 likecount에 저장

			System.out.println("좋아요 수" + likeService.getBoardCount(lDTO.getMember_id()));
			System.out.println(ckDTO.getName());
			return "redirect:/main/main";
		} else {
			return "member/msg";
		}
	}

	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/main";
	}

	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {

		System.out.println("Test");
		String userid = (String) session.getAttribute("userid");
		MemberDTO memberDTO = memberService.getMember(userid);
		model.addAttribute("memberDTO", memberDTO);

		return "member/update";
	}

	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO) {
		System.out.println("객체 : " + memberDTO);
		System.out.println("아이디 : " + memberDTO.getUserid());
		System.out.println("pw : " + memberDTO.getPassword());
		System.out.println("이름 : " + memberDTO.getName());
		MemberDTO ckDTO = memberService.userCheck(memberDTO);

		if (ckDTO != null) {
			memberService.updateMember(memberDTO);
			return "redirect:/main/main";
		} else {
			return "member/msg";
		}
	}

}
