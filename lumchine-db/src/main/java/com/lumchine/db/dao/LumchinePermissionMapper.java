package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchinePermission;
import com.lumchine.db.domain.LumchinePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchinePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    long countByExample(LumchinePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    int deleteByExample(LumchinePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    int insert(LumchinePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    int insertSelective(LumchinePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    LumchinePermission selectOneByExample(LumchinePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    LumchinePermission selectOneByExampleSelective(@Param("example") LumchinePermissionExample example, @Param("selective") LumchinePermission.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    List<LumchinePermission> selectByExampleSelective(@Param("example") LumchinePermissionExample example, @Param("selective") LumchinePermission.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    List<LumchinePermission> selectByExample(LumchinePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    LumchinePermission selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchinePermission.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    LumchinePermission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    LumchinePermission selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchinePermission record, @Param("example") LumchinePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchinePermission record, @Param("example") LumchinePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchinePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchinePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchinePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_permission
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}