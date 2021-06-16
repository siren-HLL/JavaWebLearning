package com.cswu.entity;

/**
 * 登录用户的信息
 * @author Administrator
 *
 */
public class Loginer {

	private String username;//用户名
	private String password;//密码
	private String signtime;//登录时间
	
	//定义 setter,getter方法
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSigntime() {
		return signtime;
	}
	public void setSigntime(String signtime) {
		this.signtime = signtime;
	}
	
}
