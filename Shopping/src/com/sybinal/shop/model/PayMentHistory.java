package com.sybinal.shop.model;

import java.util.Date;

public class PayMentHistory {
	private Integer id;
	private String orderNum;
	private Integer Productprice;
	private Integer userId;
	private Integer paymentType;
	private Date paymentTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Integer getProductprice() {
		return Productprice;
	}
	public void setProductprice(Integer productprice) {
		Productprice = productprice;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	
}
