package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineKeyword;
import com.lumchine.db.domain.LumchineKeywordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineKeywordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    long countByExample(LumchineKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    int insert(LumchineKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    int insertSelective(LumchineKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    LumchineKeyword selectOneByExample(LumchineKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    LumchineKeyword selectOneByExampleSelective(@Param("example") LumchineKeywordExample example, @Param("selective") LumchineKeyword.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    List<LumchineKeyword> selectByExampleSelective(@Param("example") LumchineKeywordExample example, @Param("selective") LumchineKeyword.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    List<LumchineKeyword> selectByExample(LumchineKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    LumchineKeyword selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineKeyword.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    LumchineKeyword selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    LumchineKeyword selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineKeyword record, @Param("example") LumchineKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineKeyword record, @Param("example") LumchineKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_keyword
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}