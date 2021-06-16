package com.ssm.tx;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
public class UserDaoImpl implements UserDao{
	
	//依赖注入
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user(username,password) value(?,?)";
		Object[] obj = new Object[] {
				user.getUsername(),
				user.getPassword()
		};
		int num =this.jdbcTemplate.update(sql,obj);
		return num;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from user where id=?";
		int num = this.jdbcTemplate.update(sql,id);
		return num;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		String sql = "update user set username=?,password=? where id=?";
		Object[] params = new Object[] {
				user.getUsername(),
				user.getPassword(),
				user.getId()
		};
		int num =this.jdbcTemplate.update(sql,params);
		return num;
	}
	@Override
	public User findUserById(int id) {
		String sql = "select * from user where id=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
		//RowMapper返回一个list类型结果
		//sping中的RowMapper可以将数据中的每一行数据封装成用户定义的类
		//RowMapper映射Bean容器的用法
	}
	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Transactional( propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
	//注解没有
	//赠送积分
	@Override
	public void transfer(String outUser, String inUser, Integer jf) {
		// TODO Auto-generated method stub
		//接收积分
		this.jdbcTemplate.update("update user set jf=jf+? where username=?",jf,inUser );
		//模拟系统运行时的突发性问题
		int i =1/0;//如果没有事务管理，那么接收积分的用户积分增加，赠送积分的用户的积分不变=》出错；有事务管理的话二者都不变
		//赠送积分
		this.jdbcTemplate.update("update user set jf =jf-? where username=?",jf,outUser);
	}

}
