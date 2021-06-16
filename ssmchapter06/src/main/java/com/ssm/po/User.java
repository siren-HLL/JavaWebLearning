package com.ssm.po;

public class User {
	//持久化类与普通的javabean没有区别，只是其属性与数据库字段名对应。实际上User就是一个POJO(普通java对象
	//myBatis就是采用POJO作为持久化类来完成对数据库的操作的
	private Integer id;
	private String username;
	private String jobs;
	private String phone;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJobs() {
		return jobs;
	}
	public void setJobs(String jobs) {
		this.jobs = jobs;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String toString() {
		return "User [id="+id+",username="+username+",jobs="+jobs+",phnoe="+phone+"]";
	}
}
