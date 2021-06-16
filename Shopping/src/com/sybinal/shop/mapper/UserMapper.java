package com.sybinal.shop.mapper;

import com.sybinal.shop.model.User;
import com.sybinal.shop.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	User selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByExampleSelective(@Param("record") User record,
			@Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByExample(@Param("record") User record,
			@Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByPrimaryKey(User record);
	
	
	User selectById(@Param("id") Integer id);
	
	
	List<User> selectUserByCondition(User record); 
	
	
	int selectCountByCondition(User record);

	int selectCountUserNameByCondition(String userName);
	
	int selectCountUserNameByUpdate(User record);
	
	int selectScoreCountByCondition(User record);
	
	List<User> selectScoreByCondition(User record);
	
	int updateIntegration(User record);
	
	List<User> selectRechargeByCondition(User record);
	
	int updateRecharge(User record);
	
	int updateRechargeByUserName(User record);
	
	int updateIntegrationByUserName(User record);
	
	List<User> selectDynamicTableInfo();
}