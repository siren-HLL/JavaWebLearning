package com.yxf.bookshop.controller.api;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yxf.bookshop.common.ApiResponseEnum;
import com.yxf.bookshop.common.ApiResponseObject;
import com.yxf.bookshop.model.Products;
import com.yxf.bookshop.service.product.ProductService;

/**
 * 商品信息控制层
 * @author 余晓枫，0410190109
 * 
 * */
@RestController
@RequestMapping("api/v1")
public class ProductsApiController extends AbstractApiController{
	@Autowired ProductService productService;
	
	//查询商品列表全部信息
		@RequestMapping(value = "product/findAllProducts", method = RequestMethod.GET, headers = "Accept=application/json")
		public ApiResponseObject findAllProduct() {
			List<Products> productList = productService.findAllProducts();
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),productList);
		}
		
	//删除商品，传id
		@RequestMapping(value = "product/deleteProduct", method = RequestMethod.GET, headers = "Accept=application/json")
		public ApiResponseObject deleteProduct(Integer id) {
			int row = productService.deleteProduct(id);
			String status = "";
			if(row > 0) {
				System.out.println("成功删除"+row+"条数据");
				status = "true";
			}else {
				System.out.println("删除失败");
				status = "false";
			}
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
		}
		@RequestMapping(value = "product/deleteProductPost", method = RequestMethod.POST, headers = "Accept=application/json")
		public ApiResponseObject deleteProductPost(@RequestBody Products id)throws IllegalAccessException, InvocationTargetException {
			int row = productService.deleteProductById(id);
			String status = "";
			if(row > 0) {
				System.out.println("成功删除"+row+"条数据");
				status = "true";
			}else {
				System.out.println("删除失败");
				status = "false";
			}
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
		}
//		@RequestMapping(value = "product/deleteProductPost", method = RequestMethod.POST, headers = "Accept=application/json")
//		public ApiResponseObject deleteProductPost(@RequestParam(value = "id") Integer id)throws IllegalAccessException, InvocationTargetException {
//			int row = productService.deleteProduct(id);
//			String status = "";
//			if(row > 0) {
//				System.out.println("成功删除"+row+"条数据");
//				status = "true";
//			}else {
//				System.out.println("删除失败");
//				status = "false";
//			}
//			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
//		}
//		@RequestMapping(value = "product/deleteProductPostt", method = RequestMethod.POST, headers = "Accept=application/json")
//		public ApiResponseObject deleteProductPostt(@RequestBody Integer id)throws IllegalAccessException, InvocationTargetException {
//			int row = productService.deleteProduct(id);
//			String status = "";
//			if(row > 0) {
//				System.out.println("成功删除"+row+"条数据");
//				status = "true";
//			}else {
//				System.out.println("删除失败");
//				status = "false";
//			}
//			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
//		}
		
	//新增商品信息
		@RequestMapping(value = "product/addProduct", method = RequestMethod.GET, headers = "Accept=application/json")
		public ApiResponseObject addProduct(Products record) {
			int row = productService.addProduct(record);
			String status = "";
			if(row > 0) {
				System.out.println("成功新增"+row+"条数据");
				status = "true";
			}else {
				System.out.println("新增失败");
				status = "false";
			}
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
		}
		//新增商品信息
		@RequestMapping(value = "product/addProductPost", method = RequestMethod.POST, headers = "Accept=application/json")
		public ApiResponseObject addProductPost(@RequestBody Products record )throws IllegalAccessException, InvocationTargetException {
			int row = productService.addProduct(record);
			String status = "";
			if(row > 0) {
				System.out.println("成功新增"+row+"条数据");
				status = "true";
			}else {
				System.out.println("新增失败");
				status = "false";
			}
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
		}
		
	//编辑商品信息
		@RequestMapping(value = "product/editProduct", method = RequestMethod.GET, headers = "Accept=application/json")
		public ApiResponseObject editProduct(Products record) {
			int row = productService.editProduct(record);
			String status = "";
			if(row > 0) {
				System.out.println("成功更改"+row+"条数据");
				status = "true";
			}else {
				System.out.println("更改失败");
				status = "false";
			}
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
		}
		@RequestMapping(value = "product/editProductPost", method = RequestMethod.POST, headers = "Accept=application/json")
		public ApiResponseObject editProductPost(@RequestBody Products record )throws IllegalAccessException, InvocationTargetException {
			int row = productService.editProduct(record);
			String status = "";
			if(row > 0) {
				System.out.println("成功更改"+row+"条数据");
				status = "true";
			}else {
				System.out.println("更改失败");
				status = "false";
			}
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
		}
}
