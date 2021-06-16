package com.yxf.bookshop.mapper;

import java.util.List;

import com.yxf.bookshop.model.Products;
/**
 * 商品信息Mapper,Dao层，对应同名映射文件
 * @author 余晓枫，0410190109
 * 
 * */
public interface ProductsMapper {
    
    int deleteByPrimaryKey(Integer id);
    int insert(Products record);
    int insertSelective(Products record);
    Products selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Products record);
    int updateByPrimaryKey(Products record);
    
    List<Products> selectAllProducts();
    Products selectById(Products id);
    int deleteById(Products id);
}