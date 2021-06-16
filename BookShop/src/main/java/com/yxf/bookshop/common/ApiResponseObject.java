package com.yxf.bookshop.common;

/**
 * Api的响应对象实体类
 * @author 余晓枫，0410190109
 * 
 * */
public class ApiResponseObject {
	private String errorCode;
	private String errorMsg;
	private Object data;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
