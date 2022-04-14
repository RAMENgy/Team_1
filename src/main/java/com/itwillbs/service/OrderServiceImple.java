package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.OrderDAO;
import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.OrderDTO;

@Service
public class OrderServiceImple implements OrderService {
	
	@Inject
	private OrderDAO orderDAO;
	
	
	//주문 정보 넣기
	@Override
	public void insertOrder1(OrderDTO orderDTO) {
		orderDAO.insertOrder1(orderDTO);
	}
	
	//주문 상품정보 넣기
	@Override
	public void insertOrder2(BasketDTO basketDTO) {
			orderDAO.insertOrder2(basketDTO);
	}
	
	//주문내역 조회
	@Override
	public List<OrderDTO> orderList(int member_id){
		return orderDAO.orderList(member_id);
	}
	
	//주문상세내역
	@Override
	public OrderDTO orderDetail(int id) {
		return orderDAO.orderDetail(id);
	}
	
	//주문상품 내역
	@Override
	public List<BasketDTO> orderpList(int id){
		return orderDAO.orderpList(id);
	}
	
	//주문상세 합계
	@Override
	public int sumMoney(int id) {
		return orderDAO.sumMoney(id);
	}
	
	@Override
	public Integer getMaxId() {
		return orderDAO.getMaxId();
	}
}
