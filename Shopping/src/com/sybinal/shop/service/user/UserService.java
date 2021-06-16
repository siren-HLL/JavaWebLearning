package com.sybinal.shop.service.user;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.model.FaPiao;
import com.sybinal.shop.model.User;

/**
 * 用户
 * */
public interface UserService {

	/**
	 * 用户注册 管理端用
	 * @param user
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public int saveUserForManage(User user) throws IllegalAccessException, InvocationTargetException;
	/**
	 * 修改用户信息 管理端用
	 * @param user
	 * @return
	 */
	public int updateUserForManage(User user);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int modUser(User user);
	
	/**
	 * 更新用户密码
	 * @param user
	 * @return
	 */
	public int modUserPassword(Map<String, Object> reqMap);
	
	/**
	 * 删除用户
	 * @param data
	 * @return
	 */
	public Map<String,Object> delUser(Map<String,Object> data);
	
	/**
	 * 根据用户名查询用户信息
	 * */
	public User getUser(User user);
	
	public User getUserByUserName(User user);
	/**
	 * 查询用户列表
	 * @param user
	 * @return
	 */
	public Map<String, Object> getUserInfoByCondition(PageInformation pageInfo,User User);
	
	/**
	 * 根据用户名查询用户信息
	 * */
	public User getUserById(Integer userId);
	

	
	/**
	 * 根据用户Id查询用户信息
	 * */
	User getUser(Map<String, Object> reqMap);
	
	/**
	 * 添加时验证用户名是否重复
	 */
	public int checkAddUserName(String userName) ;

	/**
	 * 修改时验证用户名是否重复
	 */
	public int checkUpdateUserName(User record) ;
	
	
	public int recoveryUserPassword(User user);
	
	/**
	 * 查询积分列表
	 * @param user
	 * @return
	 */
	public Map<String, Object> getScoreByCondition(PageInformation pageInfo,User User);
	
	public int updateIntegration(User user);
	
	/**
	 * 查询积分列表
	 * @param user
	 * @return
	 */
	public Map<String, Object> getRechargeByCondition(PageInformation pageInfo,User User);
	
	public int updateRecharge(User user);
	
	//添加发票
	public int insertFapiao(FaPiao faPiao);
	//查询所有发票
	public List<FaPiao> getFaPiaos();
	//更新发票
	public int updateFapiao(FaPiao faPiao);
	//删除发票
	public int deleteFapiao(FaPiao id_table);
	
	//jsp获取表格信息
	public List<User> getTableInfo();
}
