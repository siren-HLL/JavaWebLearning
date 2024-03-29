package com.yxf.bookshop.mapper;

import java.util.List;

import com.yxf.bookshop.model.Notices;

/**
 * 消息公告Mapper,Dao层，对应同名映射文件
 * @author 余晓枫，0410190109
 * 
 * */
public interface NoticesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notices
     *
     * @mbg.generated Mon May 24 18:37:14 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notices
     *
     * @mbg.generated Mon May 24 18:37:14 CST 2021
     */
    int insert(Notices record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notices
     *
     * @mbg.generated Mon May 24 18:37:14 CST 2021
     */
    int insertSelective(Notices record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notices
     *
     * @mbg.generated Mon May 24 18:37:14 CST 2021
     */
    Notices selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notices
     *
     * @mbg.generated Mon May 24 18:37:14 CST 2021
     */
    int updateByPrimaryKeySelective(Notices record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notices
     *
     * @mbg.generated Mon May 24 18:37:14 CST 2021
     */
    int updateByPrimaryKey(Notices record);
    
    
    
    List<Notices> selectAllNotices();
    int deleteById(Notices id);
    Notices selectById(Notices id);
}