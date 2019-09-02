package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineGoods;
import com.lumchine.db.domain.LumchineGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    long countByExample(LumchineGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    int insert(LumchineGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    int insertSelective(LumchineGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    LumchineGoods selectOneByExample(LumchineGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    LumchineGoods selectOneByExampleSelective(@Param("example") LumchineGoodsExample example, @Param("selective") LumchineGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    LumchineGoods selectOneByExampleWithBLOBs(LumchineGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    List<LumchineGoods> selectByExampleSelective(@Param("example") LumchineGoodsExample example, @Param("selective") LumchineGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    List<LumchineGoods> selectByExampleWithBLOBs(LumchineGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    List<LumchineGoods> selectByExample(LumchineGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    LumchineGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    LumchineGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    LumchineGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineGoods record, @Param("example") LumchineGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LumchineGoods record, @Param("example") LumchineGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineGoods record, @Param("example") LumchineGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LumchineGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}