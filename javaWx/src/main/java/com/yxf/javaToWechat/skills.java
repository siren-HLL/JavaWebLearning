package com.yxf.javaToWechat;

import java.io.Serializable;

public class skills implements  Serializable{
	//对象的序列化处理非常简单，只需对象实现了Serializable 接口即可（该接口仅是一个标记，没有方法）
	private static final long serialVersionUID = 1L;

	private String name;
	private String value;
	private String checked;
	public skills () {}
	public skills (String name,String value,String checked) {
		this.name =name;
		this.value = value;
		this.checked = checked;		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
}
