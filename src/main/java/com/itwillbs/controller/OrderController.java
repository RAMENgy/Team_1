package com.itwillbs.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.service.BasketService;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.OrderService;

@Controller
public class OrderController {
	
	@Inject
	private BasketService basketService;
	
	@Inject
	private MemberService memberService;
	
	@Inject
	private OrderService orderService;
	
	@RequestMapping(value="/order", method = RequestMethod.GET)
	public String order(HttpSession session, Model model) {
		
		Map<String, Object> map=new HashMap<>();
		String userid = (String)session.getAttribute("userid");
		MemberDTO memberDTO = memberService.getMember(userid);
				
		model.addAttribute("memberDTO", memberDTO); 
		
		if(memberDTO != null) {
			
			int member_id = memberDTO.getId();
			
			List<BasketDTO> basketList = basketService.basketList(member_id);
			model.addAttribute("basketList", basketList);
			
			int sumMoney = basketService.sumMoney(member_id);
			map.put("sumMoney", sumMoney);
			model.addAttribute("map", map);
			
			return "order/orderinfo";
			
		} else {
			
			return "order/msg";
		}
		
	}
	
	
	//주문정보 넣기
	@RequestMapping(value="/order/insertorder", method = RequestMethod.GET)
	public String insertOrder(OrderDTO orderDTO) {
		
		orderDTO.setStatus("주문완료");
		orderDTO.setDate(new Timestamp(System.currentTimeMillis()));
		orderService.insertOrder(orderDTO);
		
		
		return "redirect:/main/main";
	}

	
	//주문내역 보기
	@RequestMapping(value="/order/orderlist", method = RequestMethod.GET)
	public String orderList(Model model, HttpSession session) {
		
		String userid = (String)session.getAttribute("userid");
		MemberDTO memberDTO = memberService.getMember(userid);
		
		if(memberDTO != null) {
			
			int member_id = memberDTO.getId();
			
			List<OrderDTO> orderList = orderService.orderList(member_id);
			model.addAttribute("orderList", orderList);
			
			return "order/orderlist";
			
		}else {
			
			return "order/msg";
		}
		
	}
}
