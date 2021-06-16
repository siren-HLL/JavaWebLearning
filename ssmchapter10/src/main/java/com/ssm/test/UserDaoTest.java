package com.ssm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.dao.UserDao;
import com.ssm.mapper.UserMapper;
import com.ssm.po.User;

public class UserDaoTest {
	@Test
	public void findUserByIdDaoTest() {
		ApplicationContext ctn = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)ctn.getBean("userDao");
		User user = userDao.findUserById(1);
		System.out.println(user);
		
	}
	
	@Test
	public void findUserByIdMapperTest() {
		ApplicationContext ctn = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = (UserMapper)ctn.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}
}
