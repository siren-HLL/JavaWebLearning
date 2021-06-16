package com.sybinal.shop.mapper;

import java.util.List;

import com.sybinal.shop.model.FootPrint;
import com.sybinal.shop.model.Product;

public interface FootPrintMapper {
	int insertFootPrint(FootPrint footPrint);
	List<Product> selectFootPrintRelationById(FootPrint userId);
	int deleteFootPrint(FootPrint footPrint);
}
