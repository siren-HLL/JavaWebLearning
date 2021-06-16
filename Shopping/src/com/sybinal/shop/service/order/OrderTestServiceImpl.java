package com.sybinal.shop.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sybinal.shop.mapper.OrderTestMapper;
import com.sybinal.shop.model.OrderTest;

@Service
public class OrderTestServiceImpl implements OrderTestService{

	@Autowired
	OrderTestMapper orderTestMapper;
	
	@Override
	@Transactional
	public int insertOrderTest(OrderTest orderTest) {
		// TODO Auto-generated method stub
		return orderTestMapper.insertOrderTest(orderTest);
	}

	@Override
	@Transactional
	public int updatePayment(OrderTest orderTest) {
		// TODO Auto-generated method stub
		return orderTestMapper.updatePaymentType(orderTest);
	}

	@Override
	public OrderTest selectOrderInfo(OrderTest orderTest) {
		// TODO Auto-generated method stub
		return orderTestMapper.selectPaymentType(orderTest);
	}

}
