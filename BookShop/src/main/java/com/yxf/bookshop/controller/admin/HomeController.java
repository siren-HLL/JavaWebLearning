package com.yxf.bookshop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yxf.bookshop.model.Menus;
import com.yxf.bookshop.service.menu.MenuService;

/**
 * 商城后台首页
 * @author 余晓枫，0410190109
 * 
 * */
@Controller
public class HomeController {
	@Autowired MenuService menuService;
		//商城首页
		@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
		public ModelAndView home() {
			ModelAndView model = new ModelAndView();
			model.setViewName("home/home");
			List<Menus> menuInfo = menuService.findAllMenus();
			model.addObject("menus", menuInfo);
			String msg = "欢迎登录传智书城后台管理系统";
			model.addObject("msg", msg);
			String title = "Hello World";
			model.addObject("title", title);
			return model;
		}
		
		//退出登录
		@RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
		public ModelAndView logout() {
			ModelAndView model = new ModelAndView();
			model.setViewName("login/login");
			return model;
		}
		
		//菜单信息页面
		@RequestMapping(value = "/admin/menuInfo", method = RequestMethod.GET)
		public ModelAndView menuInfoPage() {
			ModelAndView model = new ModelAndView();
			model.setViewName("home/home");
			List<Menus> menuInfo = menuService.findAllMenus();
			model.addObject("menus", menuInfo);
			String msg = "您暂时没有权限浏览该板块：）";
			model.addObject("msg", msg);
			String title = "Sorry Dear User";
			model.addObject("title", title);
			return model;
		}
		//订单详情页面
			@RequestMapping(value = "/admin/orderItemInfo", method = RequestMethod.GET)
			public ModelAndView orderItemInfoPage() {
				ModelAndView model = new ModelAndView();
				model.setViewName("home/home");
				List<Menus> menuInfo = menuService.findAllMenus();
				model.addObject("menus", menuInfo);
				String msg = "您暂时没有权限浏览该板块：）";
				model.addObject("msg", msg);
				String title = "Sorry Dear User";
				model.addObject("title", title);
				return model;
			}
}
