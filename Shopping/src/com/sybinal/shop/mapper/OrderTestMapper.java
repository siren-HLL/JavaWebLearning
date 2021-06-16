package com.sybinal.shop.mapper;

import java.util.List;

import com.sybinal.shop.model.OrderTest;

public interface OrderTestMapper {
 int insertOrderTest(OrderTest orderTest);
 int updatePaymentType(OrderTest orderTest);
 OrderTest selectPaymentType(OrderTest orderTest);
}
