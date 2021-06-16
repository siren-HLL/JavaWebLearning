package com.yxf.bookshop.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yxf.bookshop.common.ApiResponseEnum;
import com.yxf.bookshop.common.ApiResponseObject;
import com.yxf.bookshop.model.Menus;
import com.yxf.bookshop.model.Users;
import com.yxf.bookshop.service.menu.MenuService;

/**
 * 商城后台系统menus-Controller,控制层
 * @author 余晓枫，0410190109
 * 
 * */
@RestController
@RequestMapping("api/v1")
public class MenusApiController extends AbstractApiController{
	@Autowired MenuService menuService;
	
	//查询菜单全部信息
	@RequestMapping(value = "menu/findAllMenu", method = RequestMethod.GET, headers = "Accept=application/json")
	public ApiResponseObject findAllMenu() {
		List<Menus> menuInfo = menuService.findAllMenus();
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),menuInfo);
		
	}
}
