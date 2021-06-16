package com.yxf.bookshop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yxf.bookshop.model.Menus;
import com.yxf.bookshop.service.menu.MenuService;

@Controller
public class NavigationController {
	@Autowired MenuService menuService;
	
	@RequestMapping(value = "/getMenuInfo", method = RequestMethod.GET)
	public ModelAndView getManuInfo() {
		ModelAndView model = new ModelAndView();
		model.setViewName("product/productInfo");
		List<Menus> menuInfo = menuService.findAllMenus();
		for (Menus menus : menuInfo) {
			System.out.println(menus);
		}
		model.addObject("menus", menuInfo);
		return model;
	}
	
	
}
