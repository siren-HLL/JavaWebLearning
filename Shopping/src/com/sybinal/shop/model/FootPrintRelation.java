package com.sybinal.shop.model;

import java.util.List;

public class FootPrintRelation extends FootPrint{
	private List<Product> productList;

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
