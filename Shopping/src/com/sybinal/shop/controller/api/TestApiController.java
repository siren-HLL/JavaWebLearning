package com.sybinal.shop.controller.api;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sybinal.shop.common.ApiResponseEnum;
import com.sybinal.shop.common.ApiResponseObject;
import com.sybinal.shop.model.Account;
import com.sybinal.shop.model.FaPiao;
import com.sybinal.shop.model.FootPrint;
import com.sybinal.shop.model.OrderItem;
import com.sybinal.shop.model.OrderTest;
import com.sybinal.shop.model.Product;
import com.sybinal.shop.model.User;
import com.sybinal.shop.service.account.AccountService;
import com.sybinal.shop.service.catalog.ProductService;
import com.sybinal.shop.service.footprint.FootPrintService;
import com.sybinal.shop.service.order.OrderTestService;
import com.sybinal.shop.service.user.UserService;

@RestController
@RequestMapping("api/v2")
public class TestApiController extends AbstractApiController{
	@Autowired
	ProductService ps;
	@Autowired
	UserService userService;
	@Autowired
	OrderTestService orderTestService;
	@Autowired
	AccountService accountService;
	@Autowired
	FootPrintService footPrintService;
	
	
	
	//通过商品类别id查询该类别下的所有商品的全部信息
	@RequestMapping(value = "catalog/getProductsByCategory/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody//用jackson的注释将返回的return对象转换为json
	public List<Product> searchProductsByCategoryId(@PathVariable("id") Integer id) {
		System.out.println(id);
		Map<String,Object> condition = new HashMap<String, Object>();
		condition.put("categoryId",id);
		Map<String,Object> product = ps.getProductByCategory(condition);
		List<Product> products = (List)product.get("productList");//model>ProductCategory.java
		return products;
	}
	//通过API方法：通过商品类别id查询该类别下的所有商品的全部信息;商品详细信息说明也在其中
	@RequestMapping(value = "catalog/getProductsByCategoryAPI/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ApiResponseObject searchProductsByCategoryIdAPI(@PathVariable("id") Integer id) {
		Map<String,Object> condition = new HashMap<String, Object>();
		condition.put("categoryId",id);
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), ps.getProductByCategory(condition));
	}
	
	//前端登录验证
	@RequestMapping(value = "user/getUserInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public ApiResponseObject getUserInfo(@RequestBody User user) throws IllegalAccessException, InvocationTargetException{
		User checkUser = userService.getUser(user);
		if(checkUser == null) {
			return reponseJSON(ApiResponseEnum.ERROR_DATA_EMPTY.getCode(), ApiResponseEnum.ERROR_DATA_EMPTY.getName(), null);
		} else{
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), checkUser);	
		}
	}
	
	//添加发票
	@RequestMapping(value = "fapiao/add", method = RequestMethod.POST, headers = "Accept=application/json") 
	public ApiResponseObject addFaPiao(@RequestBody FaPiao fapiao) throws IllegalAccessException, InvocationTargetException{
		int rows = userService.insertFapiao(fapiao);
		System.out.println(fapiao.getFplx());
		if(rows > 0) {
			System.out.println("成功添加"+rows+"条数据");
		}else {
			System.out.println("添加失败");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),rows );
	}
	
	//查询所有发票
	@RequestMapping(value = "fapiao/getInfo", method = RequestMethod.GET, headers = "Accept=application/json") 
	@ResponseBody
	public ApiResponseObject getFaPiaos(){
		List<FaPiao> fapiaos = (List)userService.getFaPiaos();
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),fapiaos);
	}
	
	//更新发票(必须传id_table
	@RequestMapping(value = "fapiao/edit", method = RequestMethod.POST, headers = "Accept=application/json") 
	public ApiResponseObject updateFaPiao(@RequestBody FaPiao faPiao)throws IllegalAccessException, InvocationTargetException{
		int rows = userService.updateFapiao(faPiao);
		System.out.println(faPiao.getId());
		if(rows > 0) {
			System.out.println("成功更新"+rows+"条数据");
		}else {
			System.out.println("更新失败");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),rows);
	}
	@RequestMapping(value = "fapiao/editGet", method = RequestMethod.GET, headers = "Accept=application/json") 
	public ApiResponseObject updateFaPiaos(FaPiao faPiao){
		int rows = userService.updateFapiao(faPiao);
		System.out.println(faPiao.getId());
		if(rows > 0) {
			System.out.println("成功更新"+rows+"条数据");
		}else {
			System.out.println("更新失败");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),rows);
	}
	
	//删除发票（传id_table）
	@RequestMapping(value = "fapiao/delete", method = RequestMethod.POST, headers = "Accept=application/json") 
	public ApiResponseObject deleteFaPiao(@RequestBody FaPiao faPiao)throws IllegalAccessException, InvocationTargetException{
		int rows = userService.deleteFapiao(faPiao);
		if(rows > 0) {
			System.out.println("成功删除"+rows+"条数据");
		}else {
			System.out.println("删除失败");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),userService.getFaPiaos());
	}
	@RequestMapping(value = "fapiao/deleteGet", method = RequestMethod.GET, headers = "Accept=application/json") 
	public ApiResponseObject deleteFaPiaoTest(FaPiao id_table){
		int rows = userService.deleteFapiao(id_table);
		if(rows > 0) {
			System.out.println("成功删除"+rows+"条数据");
		}else {
			System.out.println("删除失败");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),userService.getFaPiaos());
	}
	
	//二维码信息格式
	@RequestMapping(value = "order/insertGet", method = RequestMethod.GET, headers = "Accept=application/json") 
	public ApiResponseObject insertOrderTest(OrderTest orderTest){
		int rows = orderTestService.insertOrderTest(orderTest);
		List<String> infos = new ArrayList<String>();
		if(rows > 0) {
			System.out.println("成功插入"+rows+"条数据");
			infos.add("插入信息成功");
		}else {
			System.out.println("插入失败");
			infos.add("插入信息失败");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),infos);
	}
	@RequestMapping(value = "order/insert", method = RequestMethod.POST, headers = "Accept=application/json") 
	public ApiResponseObject insertOrderTestt(@RequestBody OrderTest orderTest)throws IllegalAccessException, InvocationTargetException{
		int rows = orderTestService.insertOrderTest(orderTest);
		List<String> infos = new ArrayList<String>();
		if(rows > 0) {
			System.out.println("成功插入"+rows+"条数据");
			infos.add("插入信息成功");
		}else {
			System.out.println("插入失败");
			infos.add("插入信息失败");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),infos);
	}
	//更新支付状态(传order_num;payment_type
	@RequestMapping(value = "order/updateGet", method = RequestMethod.GET, headers = "Accept=application/json") 
	public ApiResponseObject updateOrderTest(OrderTest orderTest){
		int rows = orderTestService.updatePayment(orderTest);
		if(rows > 0) {
			System.out.println("成功更新"+rows+"条数据");
		}else {
			System.out.println("更新失败");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),rows);
	}
	//查询支付状态（传order_num）
	@RequestMapping(value = "order/InfoGet", method = RequestMethod.GET, headers = "Accept=application/json") 
	public ApiResponseObject getOrderTest(OrderTest orderTest){
		OrderTest orderTests = orderTestService.selectOrderInfo(orderTest);
		List<String> infos = new ArrayList<String>();
		if(orderTests.getPayment_type() == 0) {
			System.out.println("手机APP返回支付状态失败");
			infos.add("支付失败");
		}else {
			System.out.println("手机APP返回支付状态成功");
			infos.add("支付成功");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),infos);
	}
	
	//充钱，数据库账户余额变更；新增充值流水记录(username必写;amount
	@RequestMapping(value = "account/czGet", method = RequestMethod.GET, headers = "Accept=application/json") 
	public ApiResponseObject insertAccountcz(Account account){
		Timestamp upt = new Timestamp(new Date().getTime());
		account.setUpdtime(upt);
		accountService.updateAccount(account);
		int rows = accountService.insertAccountRecord(account);
		if(rows > 0) {
			System.out.println("成功新增"+rows+"条数据");
		}else {
			System.out.println("新增失败");
		}
		String msg = "成功充值"+account.getAmount()+"元";
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),msg);
	}
	//充钱，数据库账户余额变更；新增充值流水记录(username必写;amount
	@RequestMapping(value = "account/cz", method = RequestMethod.POST, headers = "Accept=application/json") 
	public ApiResponseObject insertAccountczt(@RequestBody Account account)throws IllegalAccessException, InvocationTargetException{
		Timestamp upt = new Timestamp(new Date().getTime());
		account.setUpdtime(upt);
		accountService.updateAccount(account);
		int rows = accountService.insertAccountRecord(account);
		if(rows > 0) {
			System.out.println("成功新增"+rows+"条数据");
		}else {
			System.out.println("新增失败");
		}
		String msg = "成功充值"+account.getAmount()+"元";
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),msg);
	}
	
	
	//通过userid查找user信息
	@RequestMapping(value = "user/getInfo/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ApiResponseObject getUserInfo(@PathVariable("id") Integer id){
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),userService.getUserById(id));
	}
	
	//通过username查询过往充值流水记录
	@RequestMapping(value = "account/accountInfoGet", method = RequestMethod.GET, headers = "Accept=application/json") 
	@ResponseBody
	public ApiResponseObject getAccountrecordz(String username){
		System.out.println(username);
		List<Account> accounts = (List)accountService.getAccountRecord(username);
		for(Object obj:accounts) {
			System.out.println(obj);
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),accounts);
	}
//	@RequestMapping(value = "account/accountInfo", method = RequestMethod.POST, headers = "Accept=application/json")
//	@ResponseBody
//	public ApiResponseObject getAccountrecord(@RequestParam(value = "username") String username)throws IllegalAccessException, InvocationTargetException{
//		System.out.println(username);
//		List<Account> accounts = (List)accountService.getAccountRecord(username);
//		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),accounts);
//	}
	@RequestMapping(value = "account/accountInfoo", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ApiResponseObject getAccountrecord(@RequestBody Account username)throws IllegalAccessException, InvocationTargetException{
		System.out.println(username.getUsername());
		List<Account> accounts = (List)accountService.getAccountRecords(username);
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),accounts);
	}
	
	//jsp页面获取表格信息
	@RequestMapping(value = "user/getDynamicTableInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ApiResponseObject getTableInfo(){
		List<User> users = (List)userService.getTableInfo();
//		for(Object obj:users) {
//			System.out.println(obj);
//		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),users);
	}
	@RequestMapping(value = "user/getDynamicTableInfoGet", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ApiResponseObject getTableInfot(){
		List<User> users = (List)userService.getTableInfo();
//		for(Object obj:users) {
//			System.out.println(obj);
//		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),users);
	}
	
	
	//插入足迹信息(传userId;productId
	@RequestMapping(value = "footprint/addGet", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ApiResponseObject addFootPrint(FootPrint footPrint){
		System.out.println(footPrint.getUserId());
		Date now = new Date();
		footPrint.setDateTime(now);
		int rows = footPrintService.insertFootPrints(footPrint);
		if(rows > 0) {
			System.out.println("成功新增"+rows+"条数据");
		}else {
			System.out.println("新增失败");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),rows);
	}
	@RequestMapping(value = "footprint/add", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ApiResponseObject addFootPrintt(@RequestBody FootPrint footPrint)throws IllegalAccessException,InvocationTargetException{
		System.out.println(footPrint.getUserId());
		Date now = new Date();
		footPrint.setDateTime(now);
		int rows = footPrintService.insertFootPrints(footPrint);
		if(rows > 0) {
			System.out.println("成功新增"+rows+"条数据");
		}else {
			System.out.println("新增失败");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),rows);
	}
	
	
	//通过足迹查询商品-》传userId
	@RequestMapping(value = "footprint/productInfoGet", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ApiResponseObject findFootPrintProduct(FootPrint userId){
		List<Product> products = footPrintService.findFootPrintProducts(userId);
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),products);
	}
	@RequestMapping(value = "footprint/productInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ApiResponseObject findFootPrintProductt(@RequestBody FootPrint userId)throws IllegalAccessException,InvocationTargetException{
		List<Product> products = footPrintService.findFootPrintProducts(userId);
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),products);
	}
	
	//删除足迹商品-》传userId，productId
	@RequestMapping(value = "footprint/deleteGet", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ApiResponseObject deleteFootPrintProduct(FootPrint footPrint){
		int rows = footPrintService.deleteFootPrints(footPrint);
		if(rows > 0) {
			System.out.println("成功删除"+rows+"条数据");
		}else {
			System.out.println("删除失败");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),rows);
	}
	@RequestMapping(value = "footprint/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ApiResponseObject deleteFootPrintProductt(@RequestBody FootPrint footPrint)throws IllegalAccessException,InvocationTargetException{
		int rows = footPrintService.deleteFootPrints(footPrint);
		if(rows > 0) {
			System.out.println("成功删除"+rows+"条数据");
		}else {
			System.out.println("删除失败");
		}
		return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),rows);
	}
}
