package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.BasketDTO;

public interface BasketDAO {

	//새 장바구니 추가
		public void insertBasket(BasketDTO basketDTO);
		
		//장바구니 목록 조회
		public List<BasketDTO> basketList();
}
