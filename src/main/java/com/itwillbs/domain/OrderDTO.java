package com.itwillbs.domain;

import java.sql.Timestamp;
import java.util.List;

public class OrderDTO {

	private int id;
	private int member_id;
	private String receiver_name;
	private String receiver_tel;
	private String address;
	private String status;
	private Timestamp date;
	private int order_info_id;
	
	public int getOrder_info_id() {
		return order_info_id;
	}
	public void setOrder_info_id(int order_info_id) {
		this.order_info_id = order_info_id;
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

	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_tel() {
		return receiver_tel;
	}
	public void setReceiver_tel(String receiver_tel) {
		this.receiver_tel = receiver_tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
