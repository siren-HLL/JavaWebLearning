package com.yxf.bookshop.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxf.bookshop.mapper.ProductsMapper;
import com.yxf.bookshop.model.Products;
/**
 * 商品信息业务层接口实现类
 * @author 余晓枫，0410190109
 * 
 * */
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired ProductsMapper productsMapper;
	
	@Override
	public List<Products> findAllProducts() {
		// TODO Auto-generated method stub
		return productsMapper.selectAllProducts();
	}

	@Override
	public int deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		return productsMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int addProduct(Products record) {
		// TODO Auto-generated method stub
		return productsMapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int editProduct(Products record) {
		// TODO Auto-generated method stub
		return productsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteProductById(Products id) {
		// TODO Auto-generated method stub
		return productsMapper.deleteById(id);
	}

	@Override
	public Products findProductById(Products id) {
		// TODO Auto-generated method stub
		return productsMapper.selectById(id);
	}

}
