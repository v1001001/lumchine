package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineLog;
import com.lumchine.db.domain.LumchineLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    long countByExample(LumchineLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    int insert(LumchineLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    int insertSelective(LumchineLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    LumchineLog selectOneByExample(LumchineLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    LumchineLog selectOneByExampleSelective(@Param("example") LumchineLogExample example, @Param("selective") LumchineLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    List<LumchineLog> selectByExampleSelective(@Param("example") LumchineLogExample example, @Param("selective") LumchineLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    List<LumchineLog> selectByExample(LumchineLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    LumchineLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    LumchineLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    LumchineLog selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineLog record, @Param("example") LumchineLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineLog record, @Param("example") LumchineLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_log
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}