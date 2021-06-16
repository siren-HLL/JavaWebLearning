package com.yxf.bookshop.service.order;

import java.util.List;

import com.yxf.bookshop.model.Orders;
/**
 * 订单信息业务层接口
 * @author 余晓枫，0410190109
 * 
 * */
public interface OrderService {
	//查询所有订单
	public List<Orders> findAllOrders();
	//通过id查找订单
	public Orders findOrderById(Orders id);
	//通过id删除订单
	public int deleteOrderById(Orders id);
	//通过id更新订单
	public int updateOrderById(Orders order);
	//新增订单
	public int addOrder(Orders order);
}
