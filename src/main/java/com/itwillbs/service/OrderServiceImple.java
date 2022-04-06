package com.itwillbs.service;

import java.sql.Timestamp;

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
		
		orderDTO.setMember_id(1);	//수정해야됨
		orderDTO.setProduct_id(1);	//수정해야됨
		orderDTO.setBasket_id(1);	//수정해야됨
		orderDTO.setStatus("주문완료");
		orderDTO.setDate(new Timestamp(System.currentTimeMillis()));
		orderDAO.insertOrder(orderDTO);
	}
}
