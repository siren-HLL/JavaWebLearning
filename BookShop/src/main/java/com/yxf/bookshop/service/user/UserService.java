package com.yxf.bookshop.service.user;

import java.util.List;


import com.yxf.bookshop.model.Users;
/**
 * User业务层接口
 * @author 余晓枫，0410190109
 * 
 * */
public interface UserService {
	//用户注册
	public int insertUser(Users record);
	//用户登录
	public Users findUserByName(Users users);
	//获取全部用户信息
	public	List<Users> findAllUsers();
	//删除用户信息
	public int deleteUserById(Users id);
	//编辑用户信息
	public int editUser(Users record);
	//通过id获取用户信息
	public Users findUserById(Users id);
}
