package com.ssm.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
	@Test
	public void xmlTest() {
		ApplicationContext ctn = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctn.getBean("userDao");
		//赠送积分
		userDao.transfer("zhangsan", "lisi", 100);
		System.out.println("赠送积分成功");
		//执行失败，数据库无变化；因为做了事务管理
	}
	
	@Test
	public void annotationTest() {
		ApplicationContext ctn = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctn.getBean("userDao");
		//赠送积分
		userDao.transfer("zhangsan", "lisi", 200);
		System.out.println("赠送积分成功");
		//执行失败，数据库无变化；因为做了事务管理
	}
}
