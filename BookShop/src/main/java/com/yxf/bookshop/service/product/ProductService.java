package com.yxf.bookshop.service.product;

import java.util.List;

import com.yxf.bookshop.model.Products;

/**
 * 商品信息业务层接口
 * @author 余晓枫，0410190109
 * 
 * */
public interface ProductService {
	//参数类型皆为products
	
	//获取全部商品信息
	public	List<Products> findAllProducts();
	//删除商品信息
	public int deleteProduct(Integer id);
	public int deleteProductById(Products id);
	//新增商品
	public int addProduct(Products record);
	//编辑商品
	public int editProduct(Products record);
	//通过id获取商品信息
	public Products findProductById(Products id);
	
}
