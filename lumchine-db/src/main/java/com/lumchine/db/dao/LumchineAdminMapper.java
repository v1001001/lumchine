package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineAdmin;
import com.lumchine.db.domain.LumchineAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    long countByExample(LumchineAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    int insert(LumchineAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    int insertSelective(LumchineAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    LumchineAdmin selectOneByExample(LumchineAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    LumchineAdmin selectOneByExampleSelective(@Param("example") LumchineAdminExample example, @Param("selective") LumchineAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    List<LumchineAdmin> selectByExampleSelective(@Param("example") LumchineAdminExample example, @Param("selective") LumchineAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    List<LumchineAdmin> selectByExample(LumchineAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    LumchineAdmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    LumchineAdmin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    LumchineAdmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineAdmin record, @Param("example") LumchineAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineAdmin record, @Param("example") LumchineAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_admin
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}