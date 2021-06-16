package com.sybinal.shop.service.catalog;

import java.util.List;
import java.util.Map;

import com.sybinal.shop.common.PageInformation;

/**
 * 商品类别
 * */
public interface SlideService {
	public Map<String,Object> saveSlide(Map<String,Object> data);
	
	public Map<String,Object> modSlide(Map<String,Object> data);
	
	public Map<String,Object> delSlide(Map<String,Object> data);
	
}
