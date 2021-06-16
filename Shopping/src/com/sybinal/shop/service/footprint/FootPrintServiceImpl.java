package com.sybinal.shop.service.footprint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sybinal.shop.mapper.FootPrintMapper;
import com.sybinal.shop.model.FootPrint;
import com.sybinal.shop.model.Product;

@Service
public class FootPrintServiceImpl implements FootPrintService{

	@Autowired
	FootPrintMapper footPrintMapper;
	
	@Override
	@Transactional
	public int insertFootPrints(FootPrint footPrint) {
		// TODO Auto-generated method stub
		return footPrintMapper.insertFootPrint(footPrint);
	}

	@Override
	public List<Product> findFootPrintProducts(FootPrint userId) {
		// TODO Auto-generated method stub
		return footPrintMapper.selectFootPrintRelationById(userId);
	}

	@Override
	@Transactional
	public int deleteFootPrints(FootPrint footPrint) {
		// TODO Auto-generated method stub
		return footPrintMapper.deleteFootPrint(footPrint);
	}

}
