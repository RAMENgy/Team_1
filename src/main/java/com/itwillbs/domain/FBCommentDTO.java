package com.itwillbs.domain;

import java.sql.Timestamp;

public class FBCommentDTO {
	private int id;
	private int member_id;
	private int freeboard_id;
	private String content;
	private Timestamp date;
	private String name;
	
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
	public int getFreeboard_id() {
		return freeboard_id;
	}
	public void setFreeboard_id(int freeboard_id) {
		this.freeboard_id = freeboard_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
