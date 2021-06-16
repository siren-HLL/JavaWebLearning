package com.yxf.bookshop.controller.api;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yxf.bookshop.common.ApiResponseEnum;
import com.yxf.bookshop.common.ApiResponseObject;
import com.yxf.bookshop.model.Orders;
import com.yxf.bookshop.service.order.OrderService;

/**
 * 订单信息控制层
 * @author 余晓枫，0410190109
 * 
 * */
@RestController
@RequestMapping("api/v1")
public class OrdersApiController extends AbstractApiController{
	@Autowired OrderService orderService;
	
	//查询订单列表全部信息
	@RequestMapping(value = "order/findAllOrders", method = RequestMethod.GET, headers = "Accept=application/json")
	public ApiResponseObject findAllOrder() {
		List<Orders> orderList = orderService.findAllOrders();
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),orderList);
	}
			
	//删除订单，传id
	@RequestMapping(value = "order/deleteOrderPost", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject deleteOrderPost(@RequestBody Orders id)throws IllegalAccessException, InvocationTargetException {
		int row = orderService.deleteOrderById(id);
		String status = "";
		if(row > 0) {
			System.out.println("成功删除"+row+"条数据");
			status = "true";
		}else {
			System.out.println("删除失败");
			status = "false";
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
	}
	
	//新增商品信息
	@RequestMapping(value = "order/addOrder", method = RequestMethod.GET, headers = "Accept=application/json")
	public ApiResponseObject addProduct(Orders record) {
		Date now = new Date();
		record.setOrderTime(now);
		int row = orderService.addOrder(record);
		String status = "";
		if(row > 0) {
			System.out.println("成功新增"+row+"条数据");
			status = "true";
		}else {
			System.out.println("新增失败");
			status = "false";
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
	}
	@RequestMapping(value = "order/addOrderPost", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject addOrderPost(@RequestBody Orders record)throws IllegalAccessException, InvocationTargetException {
		Date now = new Date();
		record.setOrderTime(now);
		int row = orderService.addOrder(record);
		String status = "";
		if(row > 0) {
			System.out.println("成功新增"+row+"条数据");
			status = "true";
		}else {
			System.out.println("新增失败");
			status = "false";
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
	}
			
	//编辑商品信息
	@RequestMapping(value = "order/editOrder", method = RequestMethod.GET, headers = "Accept=application/json")
	public ApiResponseObject editOrder(Orders record) {
		Date now = new Date();
		record.setOrderTime(now);
		int row = orderService.updateOrderById(record);
		String status = "";
		if(row > 0) {
			System.out.println("成功更改"+row+"条数据");
			status = "true";
		}else {
			System.out.println("更改失败");
			status = "false";
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
	}
	@RequestMapping(value = "order/editOrderPost", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject editOrdertPost(@RequestBody Orders record )throws IllegalAccessException, InvocationTargetException {
//		Date now = new Date();
//		record.setOrderTime(now);
		int row = orderService.updateOrderById(record);
		String status = "";
		if(row > 0) {
			System.out.println("成功更改"+row+"条数据");
			status = "true";
		}else {
			System.out.println("更改失败");
			status = "false";
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
	}
}
