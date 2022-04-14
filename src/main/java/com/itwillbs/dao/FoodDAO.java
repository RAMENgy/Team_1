package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.FoodDTO;
import com.itwillbs.domain.PageDTO;

public interface FoodDAO {
	public List<FoodDTO> foodlist(PageDTO pageDTO);
	public List<FoodDTO> meatlist(PageDTO pageDTO);
	public List<FoodDTO> vegetablelist(PageDTO pageDTO);
	public List<FoodDTO> fruitlist(PageDTO pageDTO);
	public Integer getMaxNum();
	public Integer getMaxNummeat();
	public Integer getMaxNumfruit();
	public Integer getMaxNumvegetable();
	public int getFoodCount();
	public int getmeatCount();
	public int getvegetableCount();
	public int getfruitCount();
	public List<FoodDTO> foodlistSearch(PageDTO pageDTO);
	public int getFoodCountSearch(PageDTO pageDTO);
	public List<FoodDTO> meatlistSearch(PageDTO pageDTO);
	public int getmeatCountSearch(PageDTO pageDTO);
	public List<FoodDTO> vegetablelistSearch(PageDTO pageDTO);
	public int getvegetableCountSearch(PageDTO pageDTO);
	public List<FoodDTO> fruitlistSearch(PageDTO pageDTO);
	public int getfruitCountSearch(PageDTO pageDTO);
	public FoodDTO getfood(int id);
	public void basket(BasketDTO basketDTO);
	public Integer basketgetMaxNum();
}
	
