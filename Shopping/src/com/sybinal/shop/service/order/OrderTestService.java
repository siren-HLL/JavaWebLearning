package com.sybinal.shop.service.order;

import java.util.List;

import com.sybinal.shop.model.OrderTest;

public interface OrderTestService {
	public int insertOrderTest(OrderTest orderTest);
	public int updatePayment(OrderTest orderTest);
	public OrderTest selectOrderInfo(OrderTest orderTest);
}
