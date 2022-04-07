package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.FoodDAO;
import com.itwillbs.domain.FoodDTO;
import com.itwillbs.domain.PageDTO;

@Service
public class FoodServiceImpl implements FoodService{
	@Inject
	private FoodDAO foodDAO;

	@Override
	public List<FoodDTO> foodlist(PageDTO pageDTO) {
				int currentPage=Integer.parseInt(pageDTO.getPageNum());
				int startRow = (currentPage-1)*pageDTO.getPageSize()+1;
				int endRow=startRow+pageDTO.getPageSize()-1;
				
				pageDTO.setCurrentPage(currentPage);
				pageDTO.setStartRow(startRow);
				pageDTO.setEndRow(endRow);
				
				pageDTO.setStartRow(startRow-1);
				
				return foodDAO.foodlist(pageDTO);
	}
	@Override
	public List<FoodDTO> meatlist(PageDTO pageDTO) {
		int currentPage=Integer.parseInt(pageDTO.getPageNum());
		int startRow = (currentPage-1)*pageDTO.getPageSize()+1;
		int endRow=startRow+pageDTO.getPageSize()-1;
		
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setStartRow(startRow);
		pageDTO.setEndRow(endRow);
		
		pageDTO.setStartRow(startRow-1);
		
		return foodDAO.meatlist(pageDTO);
	}
	@Override
	public List<FoodDTO> vegetablelist(PageDTO pageDTO) {
		int currentPage=Integer.parseInt(pageDTO.getPageNum());
		int startRow = (currentPage-1)*pageDTO.getPageSize()+1;
		int endRow=startRow+pageDTO.getPageSize()-1;
		
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setStartRow(startRow);
		pageDTO.setEndRow(endRow);
		
		pageDTO.setStartRow(startRow-1);
		
		return foodDAO.vegetablelist(pageDTO);
	}
	@Override
	public List<FoodDTO> fruitlist(PageDTO pageDTO) {
		int currentPage=Integer.parseInt(pageDTO.getPageNum());
		int startRow = (currentPage-1)*pageDTO.getPageSize()+1;
		int endRow=startRow+pageDTO.getPageSize()-1;
		
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setStartRow(startRow);
		pageDTO.setEndRow(endRow);
		
		pageDTO.setStartRow(startRow-1);
		
		return foodDAO.fruitlist(pageDTO);
	}

	@Override
	public int getFoodCount() {
		// TODO Auto-generated method stub
		return foodDAO.getFoodCount();
	}
	@Override
	public int getmeatCount() {
		// TODO Auto-generated method stub
		return foodDAO.getmeatCount();
	}
	@Override
	public int getvegetableCount() {
		// TODO Auto-generated method stub
		return foodDAO.getvegetableCount();
	}
	@Override
	public int getfruitCount() {
		// TODO Auto-generated method stub
		return foodDAO.getfruitCount();
	}

}
