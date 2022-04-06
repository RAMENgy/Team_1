package com.itwillbs.service;

import javax.servlet.http.HttpSession;

import com.itwillbs.domain.OrderDTO;

public interface OrderService {

	//주문정보 넣기
	public void insertOrder(OrderDTO orderDTO);
}
