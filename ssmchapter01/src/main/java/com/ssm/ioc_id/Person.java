package com.ssm.ioc_id;

//测试实现简单的依赖注入
public class Person {
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void printInfo() {
		System.out.println("我的名字是："+name+"，我的年龄是："+age);
	}
	
}
