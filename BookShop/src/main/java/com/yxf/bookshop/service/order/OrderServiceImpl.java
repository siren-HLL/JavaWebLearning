package com.yxf.bookshop.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxf.bookshop.mapper.OrdersMapper;
import com.yxf.bookshop.model.Orders;

/**
 * 订单信息业务层接口实现类
 * @author 余晓枫，0410190109
 * 
 * */
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired OrdersMapper ordersMapper;
	
	@Override
	public List<Orders> findAllOrders() {
		// TODO Auto-generated method stub
		return ordersMapper.selectAllOrders();
	}

	@Override
	public Orders findOrderById(Orders id) {
		// TODO Auto-generated method stub
		return ordersMapper.selectById(id);
	}

	@Override
	public int deleteOrderById(Orders id) {
		// TODO Auto-generated method stub
		return ordersMapper.deleteById(id);
	}

	@Override
	@Transactional
	public int updateOrderById(Orders order) {
		// TODO Auto-generated method stub
		return ordersMapper.updateByPrimaryKeySelective(order);
	}

	@Override
	@Transactional
	public int addOrder(Orders order) {
		// TODO Auto-generated method stub
		return ordersMapper.insertSelective(order);
	}

}
