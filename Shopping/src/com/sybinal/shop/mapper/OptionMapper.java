package com.sybinal.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sybinal.shop.model.Option;
import com.sybinal.shop.model.OptionExample;
import com.sybinal.shop.model.OptionRelation;

public interface OptionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int countByExample(OptionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int deleteByExample(OptionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int insert(Option record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int insertSelective(Option record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	List<Option> selectByExample(OptionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	Option selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByExampleSelective(@Param("record") Option record,
			@Param("example") OptionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByExample(@Param("record") Option record,
			@Param("example") OptionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByPrimaryKeySelective(Option record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table option
	 * @mbggenerated  Wed Oct 19 21:07:43 CST 2016
	 */
	int updateByPrimaryKey(Option record);
	
	List<OptionRelation> selectOptionRelationByProductId(OptionExample example);
	
	int selectOptionCount(Option option);
	
	List<Option> selectOptionAll(Option option);
	
	int deleteOptionList(List<Integer> id);
	
	int selectOptionNameCount(String name);
	
	int selectOptionNameRows(Option option);
	
	int selectOptionValueCountByOptionId(@Param("id") Integer id);
	
	int selectProductCountByOptionId(@Param("id") Integer id);

	List<OptionRelation> selectOptionRelationById(OptionExample example);
	
	int selectProductOptionCountByOptionId(@Param("id") Integer id);
	
}