package com.itwillbs.domain;

import java.util.List;

public class BasketDTO {

	private int id;
	private int member_id;
	private int product_id;
	private int basket_id;
	private int count;
	private List<BasketDTO> basketlist;
	private int order_info_id;
	private String subject;
	private int subprice;
	private int amount;
	

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getSubprice() {
		return subprice;
	}
	public void setSubprice(int subprice) {
		this.subprice = subprice;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getOrder_info_id() {
		return order_info_id;
	}
	public void setOrder_info_id(int order_info_id) {
		this.order_info_id = order_info_id;
	}
	public int getBasket_id() {
		return basket_id;
	}
	public void setBasket_id(int basket_id) {
		this.basket_id = basket_id;
	}
	public List<BasketDTO> getBasketlist() {
		return basketlist;
	}
	public void setBasketlist(List<BasketDTO> basketlist) {
		this.basketlist = basketlist;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	
	

	
}
