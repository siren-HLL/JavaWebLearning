package com.sybinal.shop.service.footprint;

import java.util.List;

import com.sybinal.shop.model.FootPrint;
import com.sybinal.shop.model.Product;

public interface FootPrintService {
	public int insertFootPrints(FootPrint footPrint);
	public List<Product> findFootPrintProducts(FootPrint userId);
	public int deleteFootPrints(FootPrint footPrint);
}
