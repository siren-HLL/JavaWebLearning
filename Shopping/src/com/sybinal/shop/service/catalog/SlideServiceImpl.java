package com.sybinal.shop.service.catalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.utils.PagingTool;
import com.sybinal.shop.utils.UserUtils;

@Service
public class SlideServiceImpl implements SlideService {

	
	@Autowired
	PagingTool pagingTool;

	@Override
	@Transactional
	public Map<String, Object> saveSlide(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Map<String, Object> modSlide(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Map<String, Object> delSlide(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return null;
	}

}