package com.yxf.bookshop.common;


/**
 * 请求后台API核心方法接口
 * @author 余晓枫，0410190109
 * 
 * */
public interface HttpClientTool {
	
	/**
	 * 请求后台API核心方法
	 * @param url
	 * @param obj
	 * @return
	 * @throws ApiServiceException
	 */
	public ApiResponseObject doPostJson(String url, Object obj) throws ApiServiceException;
}
