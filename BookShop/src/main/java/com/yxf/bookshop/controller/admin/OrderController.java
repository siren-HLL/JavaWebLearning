package com.yxf.bookshop.controller.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yxf.bookshop.model.Menus;
import com.yxf.bookshop.model.Orders;
import com.yxf.bookshop.service.menu.MenuService;
import com.yxf.bookshop.service.order.OrderService;

/**
 * 商城后台订单信息页面
 * @author 余晓枫，0410190109
 * 
 * */
@Controller
public class OrderController {
	@Autowired MenuService menuService;
	@Autowired OrderService orderService;
	
	    //订单信息页面
		@RequestMapping(value = "/admin/orderInfo", method = RequestMethod.GET)
		public ModelAndView orderInfoPage() {
			ModelAndView model = new ModelAndView();
			model.setViewName("order/orderInfo");
			List<Menus> menuInfo = menuService.findAllMenus();
			model.addObject("menus", menuInfo);
			return model;
		}
		//订单编辑版面
		@RequestMapping(value = "/admin/order/EditGet", method = RequestMethod.GET)
		public ModelAndView editOrder(Orders id){
			ModelAndView model = new ModelAndView();
			Orders order = orderService.findOrderById(id);
			List<Menus> menuInfo = menuService.findAllMenus();
			model.addObject("menus", menuInfo);
			model.addObject("order", order);
			model.setViewName("order/orderEdit");
			return model;
		}
}
