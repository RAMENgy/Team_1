package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BasketDAO;
import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.ProductDTO;

@Service
public class BasketServiceImpl implements BasketService {

	@Inject
	private BasketDAO basketDAO;
	
	//새 장바구니 추가
	@Override
	public void insertBasket(BasketDTO basketDTO) {
		
		System.out.println("BasketServiceImpl insertBasket()");
		
		basketDAO.insertBasket(basketDTO);
	}
	
	//장바구니 목록 조회
	@Override
	public List<BasketDTO> basketList(int member_id){
		return basketDAO.basketList(member_id);
	}
	
	//장바구니 삭제
	@Override
	public void delete(int id) {
		basketDAO.delete(id);
	}
	
	//장바구니 전체삭제
	@Override
	public void deleteAll(int member_id) {
		basketDAO.deleteAll(member_id);
	}
	
	//장바구니 수량 가져오기
	@Override
	public int getCount(int id) {
		return basketDAO.getCount(id);
	}
	
	//장바구니 수량 변경
	@Override
	public void update(int count) {
		basketDAO.update(count);
	}
	
	//장바구니 금액 합계
	@Override
	public int sumMoney(int member_id) {
		return basketDAO.sumMoney(member_id);
	}
	
}
