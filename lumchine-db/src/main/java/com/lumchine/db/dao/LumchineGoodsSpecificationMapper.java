package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineGoodsSpecification;
import com.lumchine.db.domain.LumchineGoodsSpecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineGoodsSpecificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    long countByExample(LumchineGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    int insert(LumchineGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    int insertSelective(LumchineGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    LumchineGoodsSpecification selectOneByExample(LumchineGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    LumchineGoodsSpecification selectOneByExampleSelective(@Param("example") LumchineGoodsSpecificationExample example, @Param("selective") LumchineGoodsSpecification.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    List<LumchineGoodsSpecification> selectByExampleSelective(@Param("example") LumchineGoodsSpecificationExample example, @Param("selective") LumchineGoodsSpecification.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    List<LumchineGoodsSpecification> selectByExample(LumchineGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    LumchineGoodsSpecification selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineGoodsSpecification.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    LumchineGoodsSpecification selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    LumchineGoodsSpecification selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineGoodsSpecification record, @Param("example") LumchineGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineGoodsSpecification record, @Param("example") LumchineGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods_specification
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}