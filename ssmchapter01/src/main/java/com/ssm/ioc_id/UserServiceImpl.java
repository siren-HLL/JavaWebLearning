package com.ssm.ioc_id;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//实现UserService接口，在类中声明UserDao属性并添加属性的setter方法，同时编写login方法
//xml配置文件将userDao的bean注入userService=>在本类中new了UserDao的对象，能够使用userDao中的属性了
public class UserServiceImpl implements UserService{
	
		//声明userDao属性====>UserDao类组成的id为userDao的bean
		private UserDao  uD;
		//添加属性的setter方法,用于实现依赖注入
		public void setUserDao(UserDao userDao) {
			this.uD = userDao;
		}
		//实现接口的构造方法
		@Override
		public void login() {
			this.uD.login();//调用userDao中的login方法
			System.out.println("userService login");
		}
	
}
