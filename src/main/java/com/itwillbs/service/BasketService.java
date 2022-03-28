package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.ProductDTO;

public interface BasketService {

	//새 장바구니 추가
	public void insertBasket(BasketDTO basketDTO);
	
	//장바구니 목록 조회
	public List<BasketDTO> basketList(int member_id);
	
	//장바구니 삭제
	public void delete(int id);
}
