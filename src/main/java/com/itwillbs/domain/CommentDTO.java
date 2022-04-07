package com.itwillbs.domain;

import java.sql.Timestamp;

public class CommentDTO {
	private int id;
	private int member_id;
	private int qna_board_id;
	private String content;
	private Timestamp date;
	
	
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
	public int getQna_board_id() {
		return qna_board_id;
	}
	public void setQna_board_id(int qna_board_id) {
		this.qna_board_id = qna_board_id;
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
	
}
