package com.sybinal.shop.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sybinal.shop.common.ApiResponseEnum;
import com.sybinal.shop.common.ApiResponseObject;
import com.sybinal.shop.model.Product;
import com.sybinal.shop.service.catalog.CategoryService;
import com.sybinal.shop.service.catalog.ProductService;

@RestController
@RequestMapping("api/v1")
public class CategoryApiController extends AbstractApiController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService ps;

	
	/**
	 * 分类数据
	 * @return
	 */

	@RequestMapping(value = "catalog/category/condition", method = RequestMethod.GET, headers = "Accept=application/json")
	public ApiResponseObject getCategoryByConditionVue(Map<String, Object> reqMap) {
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), categoryService.getCategoryByCondition(reqMap));
	}
	
	
	/**
	 * 查询主页数据 Category{ Product }
	 * 
	 * @return
	 */
	@RequestMapping(value = "catalog/category/product/{pageSize}", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject searchIndexProductByHotJSON(@PathVariable("pageSize") int pageSize) {
		Map<String,Object> reqMap = new HashMap<String, Object>();
		reqMap.put("pageSize", pageSize);
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), categoryService.getCategoryRelation(reqMap));
	}
	
	

}