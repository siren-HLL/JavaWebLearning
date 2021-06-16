package com.ssm.ioc_id;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext cnt = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService =(UserService) cnt.getBean("userService");
		userService.login();

	}

}
