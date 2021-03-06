package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineOrder;
import com.lumchine.db.domain.LumchineOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    long countByExample(LumchineOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    int insert(LumchineOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    int insertSelective(LumchineOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    LumchineOrder selectOneByExample(LumchineOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    LumchineOrder selectOneByExampleSelective(@Param("example") LumchineOrderExample example, @Param("selective") LumchineOrder.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    List<LumchineOrder> selectByExampleSelective(@Param("example") LumchineOrderExample example, @Param("selective") LumchineOrder.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    List<LumchineOrder> selectByExample(LumchineOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    LumchineOrder selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineOrder.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    LumchineOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    LumchineOrder selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineOrder record, @Param("example") LumchineOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineOrder record, @Param("example") LumchineOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}