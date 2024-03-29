package com.sybinal.shop.mapper;

import com.sybinal.shop.model.OptionValue;
import com.sybinal.shop.model.OptionValueExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OptionValueMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option_value
	 * @mbg.generated  Fri Oct 21 14:28:00 CST 2016
	 */
	long countByExample(OptionValueExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option_value
	 * @mbg.generated  Fri Oct 21 14:28:00 CST 2016
	 */
	int deleteByExample(OptionValueExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option_value
	 * @mbg.generated  Fri Oct 21 14:28:00 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);
	
	int deleteByOptionId(@Param("id")Integer id);
	

	List<OptionValue> selectByOptionId(@Param("id")Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option_value
	 * @mbg.generated  Fri Oct 21 14:28:00 CST 2016
	 */
	int insert(OptionValue record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option_value
	 * @mbg.generated  Fri Oct 21 14:28:00 CST 2016
	 */
	int insertSelective(OptionValue record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option_value
	 * @mbg.generated  Fri Oct 21 14:28:00 CST 2016
	 */
	List<OptionValue> selectByExample(OptionValueExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option_value
	 * @mbg.generated  Fri Oct 21 14:28:00 CST 2016
	 */
	OptionValue selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option_value
	 * @mbg.generated  Fri Oct 21 14:28:00 CST 2016
	 */
	int updateByExampleSelective(@Param("record") OptionValue record, @Param("example") OptionValueExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option_value
	 * @mbg.generated  Fri Oct 21 14:28:00 CST 2016
	 */
	int updateByExample(@Param("record") OptionValue record, @Param("example") OptionValueExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option_value
	 * @mbg.generated  Fri Oct 21 14:28:00 CST 2016
	 */
	int updateByPrimaryKeySelective(OptionValue record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option_value
	 * @mbg.generated  Fri Oct 21 14:28:00 CST 2016
	 */
	int updateByPrimaryKey(OptionValue record);
	
	int deleteOptionValueListByOptionId(List<Integer> id);
}