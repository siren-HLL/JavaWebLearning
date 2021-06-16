package com.sybinal.shop.controller.admin;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.mapper.UserRolesMapper;
import com.sybinal.shop.model.User;
import com.sybinal.shop.model.UserRoles;
import com.sybinal.shop.model.UserRolesExample;
import com.sybinal.shop.service.user.UserService;
import com.sybinal.shop.utils.Constants;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	
	@Autowired
	UserRolesMapper userRolesMapper;

	@RequestMapping(value = "/admin/user", method = RequestMethod.GET)
	public ModelAndView userManage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/user/userInfoMain");
		return model;
	}

	@RequestMapping(value = "/admin/user/edit", method = RequestMethod.POST)
	public ModelAndView editUser(@RequestParam("userId")Integer userId,@RequestParam("roleStr")String roleStr) {
		ModelAndView model = new ModelAndView();
		User edituser = userService.getUserById(userId);
		model.addObject("user", edituser);
		if("ROLE_USER".equals(roleStr)){
			model.setViewName("admin/user/userInfoEdit");
		}else{
			model.setViewName("admin/user/userInfoEditAdmin");
		}
		return model;
	}	

	@RequestMapping(value = "/admin/user/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveUser(@RequestBody User user) throws IllegalAccessException, InvocationTargetException {
		int i = 0;
		if (user.getId() != null) {
			i = userService.updateUserForManage(user);
			if(Constants.ROLE_ADMIN.equals(user.getRole())) {
				UserRolesExample example = new UserRolesExample();
				UserRolesExample.Criteria criteria = example.createCriteria();
				User user2 = userService.getUserById(user.getId());
				criteria.andUsernameEqualTo(user2.getUserName());
				List<UserRoles> userRs = userRolesMapper.selectByExample(example);
				
	
				UserRoles userRoles=new UserRoles();
				userRoles.setUsername(user2.getUserName());
				userRoles.setRole(user.getRole());
				
				if(userRs !=null && userRs.size()>0) {
					userRolesMapper.updateByUserName(userRoles);
				}else {
					userRolesMapper.insert(userRoles);
				}
				i = 1;
			}
		} else {
			user.setEnabled(1);
			user.setRole(Constants.ROLE_ADMIN);
			i = userService.saveUserForManage(user);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (i > 0) {
			map.put("error", "0"); // 成功
			map.put("data", user); // 数据
		} else {
			map.put("error", "-1"); // 失败
			map.put("data", user); // 数据成
		}
		return map;
	}
	
	
	
	@RequestMapping(value = "/admin/adduser", method = RequestMethod.POST)
	public ModelAndView adduserManage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/user/userInfoEditAdmin");
		return model;
	}
	
	
	
	

	@RequestMapping(value = "/admin/userInfoDataTable", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userInfoDataTable(PageInformation pageInfo, User user) {
		return userService.getUserInfoByCondition(pageInfo, user);
	}
	

	
	@RequestMapping(value = "/admin/user/checkUserName", method = RequestMethod.POST)
	@ResponseBody
	public String checkUserName(HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException, IOException {
		int i = 0;
		String id=request.getParameter("id");
		String userName=request.getParameter("userName");
		User user = new User();
		if (!StringUtils.isEmpty(id)) {
			user.setId(Integer.parseInt(id));
			user.setUserName(userName);
			i = userService.checkUpdateUserName(user);
		} else {
			i = userService.checkAddUserName(userName);
		}
		if (i > 0) {
			response.getWriter().write("false");
		} else {
			response.getWriter().write("true");
		}
		return null;
	}
}
