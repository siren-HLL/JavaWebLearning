package com.ssm.ioc_id;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext cnt = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person p = (Person) cnt.getBean("person");
		p.printInfo();
	}

}
