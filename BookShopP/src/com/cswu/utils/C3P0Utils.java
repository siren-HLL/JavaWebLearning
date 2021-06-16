package com.cswu.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	
	private C3P0Utils() {}
	private static ComboPooledDataSource ds = null;
	private static ThreadLocal<Connection> tLocal = new ThreadLocal<>();
	
	
	static {
		ds = new ComboPooledDataSource();//读取默认配置文件
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	//通过连接池返回数据库连接
	public static Connection getConnection() {
		Connection con = tLocal.get();
		if(con==null) {
			try {
				con = ds.getConnection();
				tLocal.set(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	} 
}