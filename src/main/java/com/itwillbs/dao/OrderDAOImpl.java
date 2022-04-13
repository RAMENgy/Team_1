package com.itwillbs.dao;

import java.util.List;

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
	
	//주문내역 조회
	@Override
	public List<OrderDTO> orderList(int member_id){
		return sqlSession.selectList(namespace+".orderList", member_id);
	}
}
