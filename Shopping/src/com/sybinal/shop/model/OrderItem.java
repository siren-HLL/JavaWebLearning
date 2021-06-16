package com.sybinal.shop.model;

import java.util.Date;
import java.util.List;

public class OrderItem {
	private String orderNum;
	private Integer productId;
	private Integer price;
	private Integer userId;
	private String optionValueKeyGroup;
	private String jsonData;
	private Integer quantity;
	private Integer skuId;
	private Integer id;
	
	
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
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getOptionValueKeyGroup() {
		return optionValueKeyGroup;
	}
	public void setOptionValueKeyGroup(String optionValueKeyGroup) {
		this.optionValueKeyGroup = optionValueKeyGroup;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getSkuId() {
		return skuId;
	}
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	List<Product> productList;
	List<PayMentHistory> payMentHistories;


	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public List<PayMentHistory> getPayMentHistories() {
		return payMentHistories;
	}
	public void setPayMentHistories(List<PayMentHistory> payMentHistories) {
		this.payMentHistories = payMentHistories;
	}
}
