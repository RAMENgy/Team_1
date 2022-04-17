package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.OrderDTO;

public interface OrderService {

	
	//주문 정보 넣기
	public void insertOrder1(OrderDTO orderDTO);
	
	//주문 상품정보 넣기
	public void insertOrder2(BasketDTO basketDTO);
	
	//주문내역 조회
	public List<OrderDTO> orderList(int member_id);
	
	//주문 상세 내역
	public OrderDTO orderDetail(int id);
	
	//주문상품내역
	public List<BasketDTO> orderpList(int id);
	
	//장바구니 금액합계
	public int sumMoney(int id);
	
}
