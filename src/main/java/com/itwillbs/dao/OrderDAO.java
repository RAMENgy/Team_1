package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.OrderDTO;

public interface OrderDAO {

	//주문 정보 넣기
	public void insertOrder1(OrderDTO orderDTO);
	
	//주문 상품정보 넣기
	public void insertOrder2(BasketDTO basketDTO);
	
	//주문내역 조회
	public List<OrderDTO> orderList(int member_id);
	
	//주문상세내역
	public OrderDTO orderDetail(int id);
	
	//주문상품 내역
	public List<BasketDTO> orderpList(int id);
	
	//상세주문 합계
	public int sumMoney(int id);
	
}
