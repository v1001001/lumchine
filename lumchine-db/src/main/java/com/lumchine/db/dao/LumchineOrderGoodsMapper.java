package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineOrderGoods;
import com.lumchine.db.domain.LumchineOrderGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineOrderGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    long countByExample(LumchineOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    int insert(LumchineOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    int insertSelective(LumchineOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    LumchineOrderGoods selectOneByExample(LumchineOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    LumchineOrderGoods selectOneByExampleSelective(@Param("example") LumchineOrderGoodsExample example, @Param("selective") LumchineOrderGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    List<LumchineOrderGoods> selectByExampleSelective(@Param("example") LumchineOrderGoodsExample example, @Param("selective") LumchineOrderGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    List<LumchineOrderGoods> selectByExample(LumchineOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    LumchineOrderGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineOrderGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    LumchineOrderGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    LumchineOrderGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineOrderGoods record, @Param("example") LumchineOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineOrderGoods record, @Param("example") LumchineOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_order_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}