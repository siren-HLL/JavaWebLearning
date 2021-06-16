package com.ssm.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAssembleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String xmlPath = "test.xml";
		ApplicationContext ctn = new ClassPathXmlApplicationContext("test.xml"); 
		
		UserController userController = (UserController) ctn.getBean("userController");
		userController.save();

	}

}
