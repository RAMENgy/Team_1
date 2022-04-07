package com.itwillbs.dao;

import java.util.List;

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
}
