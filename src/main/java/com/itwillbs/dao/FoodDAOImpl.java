package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

}
