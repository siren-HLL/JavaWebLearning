package com.yxf.bookshop.controller.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yxf.bookshop.model.Menus;
import com.yxf.bookshop.model.Products;
import com.yxf.bookshop.service.menu.MenuService;
import com.yxf.bookshop.service.product.ProductService;

/**
 * 商城后台商品信息页面
 * @author 余晓枫，0410190109
 * 
 * */
@Controller
public class ProductController {
	@Autowired MenuService menuService;
	@Autowired ProductService productService;
 	
	//商品信息页面
	@RequestMapping(value = "/admin/productInfo", method = RequestMethod.GET)
	public ModelAndView productInfoPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("product/productInfo");
		List<Menus> menuInfo = menuService.findAllMenus();
		model.addObject("menus", menuInfo);
		return model;
	}
	
	//商品编辑版面
		@RequestMapping(value = "/admin/product/EditGet", method = RequestMethod.GET)
		public ModelAndView editProduct(Products id)throws IllegalAccessException, InvocationTargetException {
			ModelAndView model = new ModelAndView();
			Products product = productService.findProductById(id);
			List<Menus> menuInfo = menuService.findAllMenus();
			model.addObject("menus", menuInfo);
			model.addObject("product", product);
			model.setViewName("product/productEdit");
			return model;
		}
}
