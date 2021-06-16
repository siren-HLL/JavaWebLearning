package com.yxf.javaToWechat;

import java.io.Serializable;

public class gender implements  Serializable{



	private static final long serialVersionUID = 1L;
	private String name;
	private String value;
	private String checked;
	public gender (){}
	public gender (String name ,String value,String checked) {
		this.name = name;
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
