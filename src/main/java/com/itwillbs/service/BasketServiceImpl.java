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
	
}
