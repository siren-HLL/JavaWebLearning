package com.sybinal.shop.model;

import java.util.List;

public class OrderItemRelation extends OrderItem{
	private List<PayMentHistory> payMentHistories;

	public List<PayMentHistory> getPayMentHistories() {
		return payMentHistories;
	}

	public void setPayMentHistories(List<PayMentHistory> payMentHistories) {
		this.payMentHistories = payMentHistories;
	}
}
