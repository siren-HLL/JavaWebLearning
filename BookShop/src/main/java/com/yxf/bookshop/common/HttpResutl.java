package com.yxf.bookshop.common;
/**
 * 请求后台API返回结果
 * @author 余晓枫，0410190109
 * 
 * */
public class HttpResutl {
	/**
	 * 状态码
	 */
	private Integer status;
	/**
	 * 返回数据
	 */
	private String data;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public HttpResutl() {}
	public HttpResutl(Integer status, String data) {
		super();
		this.status = status;
		this.data = data;
	}
	
	

}
