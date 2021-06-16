package com.sybinal.shop.model;

public class OrderTest {
	private Integer id_order;
	private String order_num;//订单号
	private String user_id;
	private String id;//收获地址id
	private Integer payment_type;
	
	
	public Integer getId_order() {
		return id_order;
	}
	public void setId_order(Integer id_order) {
		this.id_order = id_order;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(Integer payment_type) {
		this.payment_type = payment_type;
	}
	
}
