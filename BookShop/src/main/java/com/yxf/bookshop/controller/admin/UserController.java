package com.yxf.bookshop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yxf.bookshop.model.Menus;
import com.yxf.bookshop.model.Orders;
import com.yxf.bookshop.model.Users;
import com.yxf.bookshop.service.menu.MenuService;
import com.yxf.bookshop.service.user.UserService;

/**
 * 商城后台用户信息页面
 * @author 余晓枫，0410190109
 * 
 * */
@Controller
public class UserController {
	@Autowired MenuService menuService;
	@Autowired UserService userService;
	
	//用户信息页面
	@RequestMapping(value = "/admin/userInfo", method = RequestMethod.GET)
	public ModelAndView userInfoPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/userInfo");
		List<Menus> menuInfo = menuService.findAllMenus();
		model.addObject("menus", menuInfo);
		return model;
	}
	//用户编辑版面
	@RequestMapping(value = "/admin/user/EditGet", method = RequestMethod.GET)
	public ModelAndView editUser(Users id){
		ModelAndView model = new ModelAndView();
		Users user = userService.findUserById(id);
		List<Menus> menuInfo = menuService.findAllMenus();
		model.addObject("menus", menuInfo);
		model.addObject("user", user);
		model.setViewName("user/userEdit");
		return model;
	}
}
