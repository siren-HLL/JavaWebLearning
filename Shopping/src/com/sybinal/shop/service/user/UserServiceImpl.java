package com.sybinal.shop.service.user;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.mapper.FaPiaoMapper;
import com.sybinal.shop.mapper.UserMapper;
import com.sybinal.shop.mapper.UserRolesMapper;
import com.sybinal.shop.model.FaPiao;
import com.sybinal.shop.model.User;
import com.sybinal.shop.model.UserExample;
import com.sybinal.shop.model.UserRoles;
import com.sybinal.shop.utils.Constants;
import com.sybinal.shop.utils.PagingTool;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Autowired
	UserRolesMapper userRolesMapper;

	@Autowired
	PagingTool pagingTool;
	
	@Autowired
	FaPiaoMapper faPiaoMapper;


	


	@Override
	@Transactional
	public int modUser(User user) {
		int cnt = 0;
		if (user != null) {
			if (StringUtils.isEmpty(user.getPwd()) == false) {
				Md5PasswordEncoder md5PasswordEncode = new Md5PasswordEncoder();
				String encodePassword = md5PasswordEncode.encodePassword(user.getPwd(), null);
				user.setPwd(encodePassword);
			}
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(user.getId());
			cnt = userMapper.updateByExampleSelective(user, example);
		}
		return cnt;
	}


	@Override
	@Transactional
	public int modUserPassword(Map<String, Object> reqMap) {
		int cnt = 0;
		User user = new User();
		if (reqMap != null) {
			if (!StringUtils.isEmpty((String) reqMap.get("rpassword"))) {
				Md5PasswordEncoder md5PasswordEncode = new Md5PasswordEncoder();
				String encodePassword = md5PasswordEncode.encodePassword((String) reqMap.get("rpassword"), null);
				user.setPwd(encodePassword);
			}
			String oldpassword = null;
			if (!StringUtils.isEmpty((String) reqMap.get("oldpassword"))) {
				Md5PasswordEncoder md5PasswordEncode = new Md5PasswordEncoder();
				oldpassword = md5PasswordEncode.encodePassword((String) reqMap.get("oldpassword"), null);
			}
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo((int) reqMap.get("userId"));
			criteria.andPwdEqualTo(oldpassword);
			cnt = userMapper.updateByExampleSelective(user, example);
		}
		return cnt;
	}

	@Override
	@Transactional
	public int recoveryUserPassword(User user) {
		int cnt = 0;
		if (user != null) {
			if (!StringUtils.isEmpty(user.getPwd()) && user.getPwd().equals(user.getConfirmPassword())) {
				Md5PasswordEncoder md5PasswordEncode = new Md5PasswordEncoder();
				String encodePassword = md5PasswordEncode.encodePassword(user.getPwd(), null);
				user.setPwd(encodePassword);
			}
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			criteria.andUserNameEqualTo(user.getUserName());
			cnt = userMapper.updateByExampleSelective(user, example);
		}
		return cnt;
	}
	
	@Override
	@Transactional
	public Map<String, Object> delUser(Map<String, Object> data) {

		return null;
	}

	@Override
	public User getUser(User user) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(user.getUserName());
		if (StringUtils.isEmpty(user.getPwd()) == false) {
			Md5PasswordEncoder md5PasswordEncode = new Md5PasswordEncoder();
			String encodePassword = md5PasswordEncode.encodePassword(user.getPwd(), null);
			criteria.andPwdEqualTo(encodePassword);
			User updateUser = new User();
			updateUser.setLastLoginTime(new Date());
			userMapper.updateByExampleSelective(updateUser, example);
		}
		List<User> userlist = userMapper.selectByExample(example);
		if (userlist != null && userlist.size() > 0) {
			return userlist.get(0);
		}
		return null;
	}
	
	@Override
	public User getUserByUserName(User user) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(user.getUserName());
		if (StringUtils.isEmpty(user.getPwd()) == false) {
			Md5PasswordEncoder md5PasswordEncode = new Md5PasswordEncoder();
			String encodePassword = md5PasswordEncode.encodePassword(user.getPwd(), null);
			criteria.andPwdEqualTo(encodePassword);
			User updateUser = new User();
			updateUser.setLastLoginTime(new Date());
			userMapper.updateByExampleSelective(updateUser, example);
		}
		List<User> userlist = userMapper.selectByExample(example);
		if (userlist != null && userlist.size() > 0) {
			return userlist.get(0);
		}
		return null;
	}

	@Override
	public User getUser(Map<String, Object> reqMap) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo((int) reqMap.get("userId"));
		List<User> userlist = userMapper.selectByExample(example);
		if (userlist != null && userlist.size() > 0) {
			User user = new User();
			user.setId(userlist.get(0).getId());
			user.setNickname(userlist.get(0).getNickname());
			user.setEmail(userlist.get(0).getEmail());
			return user;
		}
		return null;
	}

	@Override
	public Map<String, Object> getUserInfoByCondition(PageInformation pageInfo, User user) {
		
		int pageCount = userMapper.selectCountByCondition(user);		
		List<User> listUser = pagingTool.PagingData("com.sybinal.shop.mapper.UserMapper.selectUserByCondition", user,
				(Integer.parseInt(pageInfo.getiDisplayStart())/Integer.parseInt(pageInfo.getiDisplayLength()) +1),Integer.parseInt(pageInfo.getiDisplayLength()));

		HashMap<String, Object> datas = new HashMap<String, Object>();
		datas.put("sEcho", pageInfo.getsEcho());
		datas.put("iTotalRecords", pageCount);
		datas.put("iTotalDisplayRecords", pageCount);
		datas.put("aaData", listUser);

		return datas;
	}
	@Override
	public User getUserById(Integer userId) {
		return userMapper.selectById(userId);
	}

	@Override
	@Transactional
	public int saveUserForManage(User user) throws IllegalAccessException, InvocationTargetException {
		int cnt = 0;
		if (user != null) {
			Md5PasswordEncoder md5PasswordEncode = new Md5PasswordEncoder();
			user.setEnabled(1);
			user.setRegisterTime(new Date());
			user.setLastLoginTime(new Date());
			String encodePassword = md5PasswordEncode.encodePassword(user.getPwd(), null);
			user.setPwd(encodePassword);
			cnt += userMapper.insert(user);
			
			UserRoles userRoles=new UserRoles();
			userRoles.setUsername(user.getUserName());
			//userRoles.setRole(userRoles.getRole());
			userRoles.setRole(user.getRole());
			cnt += userRolesMapper.insert(userRoles);

		}
		return cnt;
	}

	@Override
	@Transactional
	public int updateUserForManage(User user) {
		int cnt = 0;
		if (user != null) {
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(user.getId());
			Md5PasswordEncoder md5PasswordEncode = new Md5PasswordEncoder();
			String encodePassword = md5PasswordEncode.encodePassword(user.getPwd(), null);
			user.setPwd(encodePassword);
			cnt = userMapper.updateByExampleSelective(user, example);
		}
		return cnt;
	}
	
	
	
	/**
	 * 添加时验证用户名是否重复
	 */
	@Override
	public int checkAddUserName(String userName) {
		return userMapper.selectCountUserNameByCondition(userName);
	}
	
	
	/**
	 * 修改时验证用户名是否重复
	 */
	@Override
	public int checkUpdateUserName(User record) {
		return userMapper.selectCountUserNameByUpdate(record);
	}
	
	
	@Override
	public Map<String, Object> getScoreByCondition(PageInformation pageInfo, User user) {
		
		int pageCount = userMapper.selectScoreCountByCondition(user);		
		List<User> listUser = pagingTool.PagingData("com.sybinal.shop.mapper.UserMapper.selectScoreByCondition", user,
				(Integer.parseInt(pageInfo.getiDisplayStart())/Integer.parseInt(pageInfo.getiDisplayLength()) +1),Integer.parseInt(pageInfo.getiDisplayLength()));

		HashMap<String, Object> datas = new HashMap<String, Object>();
		datas.put("sEcho", pageInfo.getsEcho());
		datas.put("iTotalRecords", pageCount);
		datas.put("iTotalDisplayRecords", pageCount);
		datas.put("aaData", listUser);

		return datas;
	}


	@Override
	public int updateIntegration(User user) {
		return userMapper.updateIntegration(user);
	}
	
	@Override
	public Map<String, Object> getRechargeByCondition(PageInformation pageInfo, User user) {
		
		int pageCount = userMapper.selectScoreCountByCondition(user);		
		List<User> listUser = pagingTool.PagingData("com.sybinal.shop.mapper.UserMapper.selectRechargeByCondition", user,
				(Integer.parseInt(pageInfo.getiDisplayStart())/Integer.parseInt(pageInfo.getiDisplayLength()) +1),Integer.parseInt(pageInfo.getiDisplayLength()));

		HashMap<String, Object> datas = new HashMap<String, Object>();
		datas.put("sEcho", pageInfo.getsEcho());
		datas.put("iTotalRecords", pageCount);
		datas.put("iTotalDisplayRecords", pageCount);
		datas.put("aaData", listUser);

		return datas;
	}


	@Override
	public int updateRecharge(User user) {
		return userMapper.updateRecharge(user);
	}

//发票
	@Override
	@Transactional
	public int insertFapiao(FaPiao faPiao) {
		// TODO Auto-generated method stub
		return faPiaoMapper.insertFaPiao(faPiao);
	}


	@Override
	public List<FaPiao> getFaPiaos() {
		// TODO Auto-generated method stub
		return faPiaoMapper.getFapiaoInfo();
	}


	@Override
	@Transactional
	public int updateFapiao(FaPiao faPiao) {
		// TODO Auto-generated method stub
		return faPiaoMapper.updateFapiaoByTableId(faPiao);
	}


	@Override
	@Transactional
	public int deleteFapiao(FaPiao id_table) {
		// TODO Auto-generated method stub
		return faPiaoMapper.deleteFapiaoByPrimarykey(id_table);
	}


	@Override
	public List<User> getTableInfo() {
		// TODO Auto-generated method stub
		return userMapper.selectDynamicTableInfo();
	}
	
}
