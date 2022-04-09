package com.itwillbs.domain;

import java.sql.Timestamp;

public class RecipeDTO {
	private int id;
	private int member_id;
	private String subject;
	private String img;
	private String ingredient;
	private String content;
	private int readcount;
	private int like_count;
	private Timestamp date;
	private String like_search;
	private int search_id;
	
	public int getSearch_id() {
		return search_id;
	}
	public void setSearch_id(int search_id) {
		this.search_id = search_id;
	}
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public String getLike_search() {
		return like_search;
	}
	public void setLike_search(String likesearch) {
		this.like_search = likesearch;
	}
	
	
}
