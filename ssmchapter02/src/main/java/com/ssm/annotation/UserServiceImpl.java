package com.ssm.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userDao")
	private UserDao us;

	@Override
	public void save() {
		// TODO Auto-generated method stub
		this.us.save();
		System.out.println("执行userService.save()");
		
	}

}
