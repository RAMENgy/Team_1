package com.itwillbs.domain;

public class LikeDTO {
	
	private int id;
	private int member_id;
	private int recipe_board_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getRecipe_board_id() {
		return recipe_board_id;
	}
	public void setRecipe_board_id(int recipe_board_id) {
		this.recipe_board_id = recipe_board_id;
	}
	
	
}
