package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.ProductDTO;

public interface BasketService {

	//새 장바구니 추가
	public void insertBasket(BasketDTO basketDTO);
	
	//장바구니 목록 조회
	public List<ProductDTO> basketList(String id);
	
}
