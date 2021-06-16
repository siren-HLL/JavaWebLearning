package com.ssm.ioc_id;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.*;
import org.omg.CORBA.portable.ApplicationException;

public class IoC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化spring容器，加载配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		userDao.login();
	}

}
