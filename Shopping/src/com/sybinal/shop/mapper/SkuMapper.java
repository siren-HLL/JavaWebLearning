package com.sybinal.shop.mapper;

import com.sybinal.shop.model.Sku;
import com.sybinal.shop.model.SkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkuMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	long countByExample(SkuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	int deleteByExample(SkuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	int insert(Sku record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	int insertSelective(Sku record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	List<Sku> selectByExampleWithBLOBs(SkuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	List<Sku> selectByExample(SkuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	Sku selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	int updateByExampleSelective(@Param("record") Sku record, @Param("example") SkuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") Sku record, @Param("example") SkuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	int updateByExample(@Param("record") Sku record, @Param("example") SkuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	int updateByPrimaryKeySelective(Sku record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(Sku record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sku
	 *
	 * @mbg.generated Wed Oct 26 10:17:30 CST 2016
	 */
	int updateByPrimaryKey(Sku record);

	int updateQuantityByExample(@Param("record") Sku record, @Param("example") SkuExample example);
}