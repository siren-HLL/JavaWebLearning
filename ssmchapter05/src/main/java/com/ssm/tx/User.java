package com.ssm.tx;

//User实例类
public class User {
	private Integer id;
	private String username;
	private String password;
	//测试事物管理:积分管理
	private Integer jf;
	public Integer getJf() {
		return jf;
	}
	public void setJf(Integer jf) {
		this.jf = jf;
	}
	//ID
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	//username
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	//password
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//查询打印信息
	public String toString() {
		return "User[id="+id+",username="+username+",password="+password+"]";
	}
	
}
