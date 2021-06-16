package com.ssm.aspectj.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.aspectj.UserDao;

public class TestAspectjAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctn = new ClassPathXmlApplicationContext("com/ssm/aspectj/annotation/applicationContext.xml");
		UserDao userDao = (UserDao) ctn.getBean("userDao");
		userDao.addUser();
	}

}
