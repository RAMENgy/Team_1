package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.OrderDAO;
import com.itwillbs.domain.OrderDTO;

@Service
public class OrderServiceImple implements OrderService {
	
	@Inject
	private OrderDAO orderDAO;
	
	//주문정보 넣기
	@Override
	public void insertOrder(OrderDTO orderDTO) {
		
		
			orderDAO.insertOrder(orderDTO);
		
	}
	
	//주문내역 조회
	@Override
	public List<OrderDTO> orderList(int member_id){
		return orderDAO.orderList(member_id);
	}
}
