package com.yxf.bookshop.common;

/**
 * Api异常
 * @author 余晓枫，0410190109
 * 
 * */
public class ApiServiceException extends Exception{
	
	private static final long serialVersionUID = 1L;	
	
	public ApiServiceException(String msg) {
		super(msg);
	}

}
