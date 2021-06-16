package com.yxf.bookshop.service.menu;

import java.util.List;

import com.yxf.bookshop.model.Menus;

/**
 * 菜单业务层接口
 * @author 余晓枫，0410190109
 * 
 * */
public interface MenuService {
	//查找全部菜单信息
	public List<Menus> findAllMenus();
}
