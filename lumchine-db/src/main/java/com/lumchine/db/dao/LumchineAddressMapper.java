package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineAddress;
import com.lumchine.db.domain.LumchineAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    long countByExample(LumchineAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    int insert(LumchineAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    int insertSelective(LumchineAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    LumchineAddress selectOneByExample(LumchineAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    LumchineAddress selectOneByExampleSelective(@Param("example") LumchineAddressExample example, @Param("selective") LumchineAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    List<LumchineAddress> selectByExampleSelective(@Param("example") LumchineAddressExample example, @Param("selective") LumchineAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    List<LumchineAddress> selectByExample(LumchineAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    LumchineAddress selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    LumchineAddress selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    LumchineAddress selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineAddress record, @Param("example") LumchineAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineAddress record, @Param("example") LumchineAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_address
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}