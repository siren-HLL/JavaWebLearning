package com.yxf.bookshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 商城后台登录页面
 * @author 余晓枫，0410190109
 * 
 * */

@Controller
//@Controller可返回视图
public class LoginController {
	//登录页面controller
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login/login");
		return model;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView loginToIndex() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login/login");
		return model;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login/register");
		return model;
	}	
	
	
}
