package com.yxf.bookshop.controller.api;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yxf.bookshop.common.ApiResponseEnum;
import com.yxf.bookshop.common.ApiResponseObject;
import com.yxf.bookshop.model.Users;
import com.yxf.bookshop.service.user.UserService;
/**
 * 商城后台系统users-Controller,控制层
 * @author 余晓枫，0410190109
 * 
 * */
@RestController
@RequestMapping("api/v1")
public class UsersApiController extends AbstractApiController{
	
	@Autowired UserService userService;
	
	//用户登录验证Get；传username,password
	@RequestMapping(value = "user/checkUser", method = RequestMethod.GET, headers = "Accept=application/json")
	public ApiResponseObject findByUserName(Users user) {
		Users userInfo = userService.findUserByName(user);
		System.out.print(user.getPassword());
		if(userInfo != null && user.getPassword().equals(userInfo.getPassword())) {
			Users userResult = userInfo;
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),userResult);
		}else {
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),"");
		}
	}
	
	//用户登录验证Post；传username,password
		@RequestMapping(value = "user/checkUserPost", method = RequestMethod.POST, headers = "Accept=application/json")
		public ApiResponseObject findByUserNamePost(@RequestBody Users user) throws IllegalAccessException, InvocationTargetException{
			Users userInfo = userService.findUserByName(user);
			System.out.print(user.getPassword());
			if(userInfo != null && user.getPassword().equals(userInfo.getPassword())) {
				Users userResult = userInfo;
				return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),userResult);
			}else {
				return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),"");
			}
		}
		
		//查询用户列表全部信息
		@RequestMapping(value = "user/findAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
		public ApiResponseObject findAllUsers() {
			List<Users> userList = userService.findAllUsers();
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),userList);
		}
				
		//删除用户，传id
		@RequestMapping(value = "user/deleteUserPost", method = RequestMethod.POST, headers = "Accept=application/json")
		public ApiResponseObject deleteUserPost(@RequestBody Users id)throws IllegalAccessException, InvocationTargetException {
			int row = userService.deleteUserById(id);
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
		
		//新增用户
		@RequestMapping(value = "user/addUserPost", method = RequestMethod.POST, headers = "Accept=application/json")
		public ApiResponseObject addOrderPost(@RequestBody Users record)throws IllegalAccessException, InvocationTargetException {
			Date now = new Date();
			record.setRegisttime(now);
			int row = userService.insertUser(record);
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
		
		//编辑用户
		@RequestMapping(value = "user/editUserPost", method = RequestMethod.POST, headers = "Accept=application/json")
		public ApiResponseObject editUserPost(@RequestBody Users record )throws IllegalAccessException, InvocationTargetException {
//			Date now = new Date();
//			record.setRegisttime(now);
			int row = userService.editUser(record);
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
