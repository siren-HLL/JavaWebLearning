package com.yxf.bookshop.controller.api;

import com.yxf.bookshop.common.ApiResponseObject;
/**
 * 通用ApiCtroller的抽象方法
 * @author 余晓枫，0410190109
 * 
 * */
public abstract class AbstractApiController {
	public ApiResponseObject reponseJSON(String errorCode, String errorMsg, Object resData) {
		ApiResponseObject apiResponseObject = new ApiResponseObject();
		apiResponseObject.setErrorCode(errorCode);
		apiResponseObject.setErrorMsg(errorMsg);
		apiResponseObject.setData(resData);
		return apiResponseObject;
	}

}
