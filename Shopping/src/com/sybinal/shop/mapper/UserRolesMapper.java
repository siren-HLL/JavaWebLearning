package com.sybinal.shop.mapper;

import com.sybinal.shop.model.UserRoles;
import com.sybinal.shop.model.UserRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRolesMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_roles
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int countByExample(UserRolesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_roles
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int deleteByExample(UserRolesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_roles
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int deleteByPrimaryKey(Integer userRoleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_roles
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int insert(UserRoles record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_roles
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int insertSelective(UserRoles record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_roles
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	List<UserRoles> selectByExample(UserRolesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_roles
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	UserRoles selectByPrimaryKey(Integer userRoleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_roles
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByExampleSelective(@Param("record") UserRoles record,
			@Param("example") UserRolesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_roles
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByExample(@Param("record") UserRoles record,
			@Param("example") UserRolesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_roles
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByPrimaryKeySelective(UserRoles record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_roles
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByPrimaryKey(UserRoles record);
	
	int updateByUserName(UserRoles record);
}