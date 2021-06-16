package com.ssm.jdbc;

import java.util.List;

public interface UserDao {
	//增删改
	public int addUser(User user); 
	public int deleteUser(int id);
	public int updateUser(User user);
	//查询操作
	public User findUserById(int id);
	public List<User> findAllUser();
}
