package com.yxf.bookshop.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxf.bookshop.mapper.UsersMapper;
import com.yxf.bookshop.model.Users;

/**
 * User业务层接口实现类
 * @author 余晓枫，0410190109
 * 
 * */
@Service
//Spring自动装配bean
public class UserServiceImpl implements UserService{
	
	@Autowired UsersMapper usersMapper;

	@Override
	@Transactional
	public int insertUser(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.insertSelective(record);
	}

	@Override
	public Users findUserByName(Users users) {
		// TODO Auto-generated method stub
		return usersMapper.selectByUserName(users);
	}

	@Override
	public List<Users> findAllUsers() {
		// TODO Auto-generated method stub
		return usersMapper.selectAllUsers();
	}

	@Override
	public int deleteUserById(Users id) {
		// TODO Auto-generated method stub
		return usersMapper.deleteById(id);
	}

	@Override
	@Transactional
	public int editUser(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Users findUserById(Users id) {
		// TODO Auto-generated method stub
		return usersMapper.selectById(id);
	}

}
