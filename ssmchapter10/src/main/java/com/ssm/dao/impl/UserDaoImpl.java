package com.ssm.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ssm.dao.UserDao;
import com.ssm.po.User;
//在配置中给bean注入了一个sqlSessionFactory,所以子类userDaoImpl能直接调用getSqlSession()
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("com.ssm.po.UserMapper.findUserById",id);
	}

}
