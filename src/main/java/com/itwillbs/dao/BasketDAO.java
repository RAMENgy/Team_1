package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.ProductDTO;

public interface BasketDAO {

		//새 장바구니 추가
		public void insertBasket(BasketDTO basketDTO);
		
		//장바구니 목록 조회
		public List<BasketDTO> basketList(int member_id);
		
		//장바구니 삭제
		public void delete(int id);
		
		//장바구니 전체삭제
		public void deleteAll(int member_id);
		
		//장바구니 수량 가져오기
		public int getCount(int id);
		
		//장바구니 수량변경
		public void update(int count);		
		
		//장바구니 금액합계
		public int sumMoney(int member_id);

}
