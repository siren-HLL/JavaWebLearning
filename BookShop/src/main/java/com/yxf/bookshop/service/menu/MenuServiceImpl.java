package com.yxf.bookshop.service.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxf.bookshop.mapper.MenusMapper;
import com.yxf.bookshop.model.Menus;

/**
 * 菜单业务层接口实现类
 * @author 余晓枫，0410190109
 * 
 * */
@Service
public class MenuServiceImpl implements MenuService{

	@Autowired MenusMapper menuMapper;
	
	@Override
	public List<Menus> findAllMenus() {
		// TODO Auto-generated method stub
		return menuMapper.findAllMenu();
	}
	
}
