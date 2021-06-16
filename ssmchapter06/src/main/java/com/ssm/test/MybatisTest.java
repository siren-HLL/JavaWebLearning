package com.ssm.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssm.po.User;

public class MybatisTest {
	//根据id查询用户信息
	@Test
	public void findUserByIdTest() throws Exception{
		//通过输入流，读取配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//根据配置文件构建sqlSessionFactory实例
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过sqlSessionFactory创建sqlSession实例
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession执行映射文件中的sql.并返回映射结果
		User user = sqlSession.selectOne("com.ssm.mapper.UserMapper.findUserById",1);
		//打印结果
		System.out.println(user.toString());
		//关闭SqlSession
		sqlSession.close();
	}
	
	//根据用户名模糊查询用户信息
	@Test
	public void findUserByNameTest() throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> users = sqlSession.selectList("com.ssm.mapper.UserMapper.findUserByName","Kimi");
		for (User u : users ) {
			System.out.println(u.toString());
		}
		sqlSession.close();
	}
	
	//添加用户
	@Test
	public void addUserTest() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建User对象并向对象中添加数据
		User user = new User();
		user.setUsername("Kimi");
		user.setJobs("farmer");
		user.setPhone("18117099855");
		//执行sql,返回受影响的行数
		int rows = sqlSession.insert("com.ssm.mapper.UserMapper.addUser", user);
		if(rows > 0) {
			System.out.println("成功添加"+rows+"条数据");
		}else {
			System.out.println("添加失败");
		}
		//提交事务
		sqlSession.commit();
		sqlSession.close();
	}
	
	//更新用户
	@Test
	public void updateUserTest() throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//模拟更新
		User user = new User();
		user.setId(8);
		user.setUsername("Kimi");
		user.setJobs("programmer");
		user.setPhone("18873450906");
		int rows = sqlSession.update("com.ssm.mapper.UserMapper.updateUser",user);
		if(rows > 0) {
			System.out.println("成功修改"+rows+"条数据");
		}else {
			System.out.println("修改失败");
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	//删除用户
	@Test
	public void deleteUserText() throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int rows = sqlSession.delete("com.ssm.mapper.UserMapper.deleteUser",10);
		if(rows > 0) {
			System.out.println("成功删除"+rows+"条数据");
		}else {
			System.out.println("删除失败");
		}
		sqlSession.commit();
		sqlSession.close();

	}
	
	
	
	
	
	
	
	
	
	
}
