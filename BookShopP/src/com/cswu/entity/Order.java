package com.cswu.entity;

import java.util.Date;

/**
 * ¶©µ¥ĞÅÏ¢
 * @author Administrator
 *
 */
public class Order {

	private int id;
	private int user_id;
	private double money;
	private int pay_state;
	private String guest_name;
	private String guest_address;
	private String guest_phone;
	private Date order_time;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getPay_state() {
		return pay_state;
	}
	public void setPay_state(int pay_state) {
		this.pay_state = pay_state;
	}
	public String getGuest_name() {
		return guest_name;
	}
	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}
	public String getGuest_address() {
		return guest_address;
	}
	public void setGuest_address(String guest_address) {
		this.guest_address = guest_address;
	}
	public String getGuest_phone() {
		return guest_phone;
	}
	public void setGuest_phone(String guest_phone) {
		this.guest_phone = guest_phone;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
