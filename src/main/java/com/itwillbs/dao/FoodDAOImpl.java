package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.FoodDTO;
import com.itwillbs.domain.PageDTO;
@Repository
public class FoodDAOImpl implements FoodDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.FoodMapper";
	@Override
	public List<FoodDTO> foodlist(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".foodList",pageDTO);
	}
	@Override
	public List<FoodDTO> meatlist(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".meatList",pageDTO);
	}
	@Override
	public List<FoodDTO> vegetablelist(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".vegetableList",pageDTO);
	}
	@Override
	public List<FoodDTO> fruitlist(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".fruitList",pageDTO);
	}
	@Override
	public Integer getMaxNum() {
		return sqlSession.selectOne(namespace+".getMaxNum");
	}
	@Override
	public int getFoodCount() {
		return sqlSession.selectOne(namespace+".getfoodCount");
	}
	@Override
	public Integer getMaxNummeat() {
		return sqlSession.selectOne(namespace+".getMaxNummeat");
	}
	@Override
	public Integer getMaxNumvegetable() {
		return sqlSession.selectOne(namespace+".getMaxNumvegetable");
	}
	@Override
	public Integer getMaxNumfruit() {
		return sqlSession.selectOne(namespace+".getMaxNumfruit");
	}
	@Override
	public int getmeatCount() {
		return sqlSession.selectOne(namespace+".getfoodCount");
	}
	@Override
	public int getvegetableCount() {
		return sqlSession.selectOne(namespace+".getvegetableCount");
	}
	@Override
	public int getfruitCount() {
		return sqlSession.selectOne(namespace+".getfruitCount");
	}
	@Override
	public List<FoodDTO> foodlistSearch(PageDTO pageDTO) {

		return sqlSession.selectList(namespace+".foodListSearch",pageDTO);
	}
	@Override
	public int getFoodCountSearch(PageDTO pageDTO) {
		return sqlSession.selectOne(namespace+".getfoodCountSearch",pageDTO);
	}
	@Override
	public List<FoodDTO> meatlistSearch(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".meatListSearch",pageDTO);
	}
	@Override
	public int getmeatCountSearch(PageDTO pageDTO) {
		return sqlSession.selectOne(namespace+".getmeatCountSearch",pageDTO);
	}
	@Override
	public List<FoodDTO> vegetablelistSearch(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".vegetableListSearch",pageDTO);
	}
	@Override
	public int getvegetableCountSearch(PageDTO pageDTO) {
		return sqlSession.selectOne(namespace+".getvegetableCountSearch",pageDTO);
	}
	@Override
	public List<FoodDTO> fruitlistSearch(PageDTO pageDTO) {
		return sqlSession.selectList(namespace+".fruitListSearch",pageDTO);
	}
	@Override
	public int getfruitCountSearch(PageDTO pageDTO) {
		return sqlSession.selectOne(namespace+".getfruitCountSearch",pageDTO);
	}
	@Override
	public FoodDTO getfood(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getfood",id);
				
	}
	@Override
	public void basket(BasketDTO basketDTO) {
		sqlSession.insert(namespace+".basket", basketDTO);		
	}
	@Override
	public Integer basketgetMaxNum() {
		return sqlSession.selectOne(namespace+".basketgetMaxNum");
	}

}
