package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineIssue;
import com.lumchine.db.domain.LumchineIssueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineIssueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    long countByExample(LumchineIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    int insert(LumchineIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    int insertSelective(LumchineIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    LumchineIssue selectOneByExample(LumchineIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    LumchineIssue selectOneByExampleSelective(@Param("example") LumchineIssueExample example, @Param("selective") LumchineIssue.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    List<LumchineIssue> selectByExampleSelective(@Param("example") LumchineIssueExample example, @Param("selective") LumchineIssue.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    List<LumchineIssue> selectByExample(LumchineIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    LumchineIssue selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineIssue.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    LumchineIssue selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    LumchineIssue selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineIssue record, @Param("example") LumchineIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineIssue record, @Param("example") LumchineIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_issue
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}