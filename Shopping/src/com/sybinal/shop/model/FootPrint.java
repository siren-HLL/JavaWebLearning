package com.sybinal.shop.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FootPrint {
	private Integer id;
	private Integer userId;
	private Integer productId;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
	private Date dateTime;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public FootPrint(Integer id, Integer userId, Integer productId, Date dateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.dateTime = dateTime;
	}
	public FootPrint() {
		
	}
	
	
}
