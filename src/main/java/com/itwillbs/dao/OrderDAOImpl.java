package com.itwillbs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.OrderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.orderMapper";
	
	
	//주문정보 넣기
	@Override
	public void insertOrder1(OrderDTO orderDTO) {
		sqlSession.insert(namespace+".insertOrder1", orderDTO);
	}
	//주문 상품정보 넣기
	@Override
	public void insertOrder2(BasketDTO basketDTO) {
		sqlSession.insert(namespace+".insertOrder2", basketDTO);
	}
	
	//주문내역 조회
	@Override
	public List<OrderDTO> orderList(int member_id){
		return sqlSession.selectList(namespace+".orderList", member_id);
	}
	
	//주문상세 내역
	@Override
	public OrderDTO orderDetail(int id) {
		return sqlSession.selectOne(namespace+".orderDetail", id);
	}
	
	//주문상품내역
	@Override
	public List<BasketDTO> orderpList(int id){
		return sqlSession.selectList(namespace+".orderpList", id);
	}
	
	//상세주문 합계
	@Override
	public int sumMoney(int id) {
		return sqlSession.selectOne(namespace+".sumMoney", id);
	}
	
	@Override
	public Integer getMaxId() {
		return sqlSession.selectOne(namespace+".getMaxId");
	}

}
