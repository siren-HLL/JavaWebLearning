package com.ssm.aspectj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.aspectj.UserDao;

public class TestXmlAspectJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String xmlPath ="com/ssm/aspectj/xml/applicationContext.xml";
//		ApplicationContext ctn = new ClassPathXmlApplicationContext(xmlPath);
		ApplicationContext ctn = new ClassPathXmlApplicationContext("com/ssm/aspectj/xml/applicationContext.xml");
		UserDao userDao = (UserDao) ctn.getBean("userDao");
		userDao.addUser();
	}

}
