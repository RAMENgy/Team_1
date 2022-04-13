package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.OrderDTO;

public interface OrderService {

	//주문정보 넣기
	public void insertOrder(OrderDTO orderDTO);
	
	//주문내역 조회
	public List<OrderDTO> orderList(int member_id);
	
}
