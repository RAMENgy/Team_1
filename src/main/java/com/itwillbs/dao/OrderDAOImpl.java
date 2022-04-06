package com.itwillbs.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.OrderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.orderMapper";
	
	//주문정보 넣기
	@Override
	public void insertOrder(OrderDTO orderDTO) {
		sqlSession.insert(namespace+".insertOrder", orderDTO);
	}
}
