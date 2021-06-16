package com.ssm.tx;



import java.util.List;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

//使用excute方法建表
public class jdbcTemplateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//加载配置文件
		ApplicationContext cnt = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取jdbcTemplate实例
		JdbcTemplate jdbcTemplate = (JdbcTemplate) cnt.getBean("jdbcTemplate");
		//使用excute方法执行sql语句创建用户表user
		jdbcTemplate.execute("create table user("+
				"id int primary key auto_increment,"+
				"username varchar(40),"+
				"password varchar(40))");
		
		
		
	}
	@Test
	//使用Junit测试
	//测试添加用户方法
			public void addUserTest() {
				ApplicationContext cn = new ClassPathXmlApplicationContext("applicationContext.xml");
				UserDao  ud = (UserDao) cn.getBean("userDao");
				//User实例
				User user = new User();
				//User实例属性？？对象.非静态方法
				user.setUsername("zhangsan");
				user.setPassword("123456");
				//添加用户
				int num = ud.addUser(user);
				if(num>0) {
					System.out.println("成功插入了"+num+"条数据");
				}else {
					System.out.println("插入操作失败");
				}
			}
	
	@Test
	//测试update方法
	public void updateUerTest() {
		ApplicationContext cn = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao  ud = (UserDao) cn.getBean("userDao");
		User user = new User();
		user.setId(2);
		user.setUsername("siren");
		user.setPassword("120410");
		int num = ud.updateUser(user);
		if(num>0) {
			System.out.println("成功更新"+num+"条数据");
		}else {
			System.out.println("更新操作执行失败");
		}
	}
	
	@Test
	//测试delete方法
	public void deleteUserTest() {
		ApplicationContext cn = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao  ud = (UserDao) cn.getBean("userDao");
		int num = ud.deleteUser(4);
		if(num>0) {
			System.out.println("成功删除"+num+"条数据");
		}else {
			System.out.println("删除操作执行失败");
		}
	}

	@Test
	//测试通过id查询
	public void findUserByIdTest() {
		ApplicationContext cn = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao  ud = (UserDao) cn.getBean("userDao");
		User user = ud.findUserById(2);
		System.out.println(user);
	}
	
	@Test
	public void findAllUaerTest() {
		ApplicationContext cn = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao  ud = (UserDao) cn.getBean("userDao");
		//查询所有用户信息
		List<User> list = ud.findAllUser();
		for(User user:list) {//结果list里面的User类user对象？
			System.out.println(user);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
