package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineUser;
import com.lumchine.db.domain.LumchineUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    long countByExample(LumchineUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    int insert(LumchineUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    int insertSelective(LumchineUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    LumchineUser selectOneByExample(LumchineUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    LumchineUser selectOneByExampleSelective(@Param("example") LumchineUserExample example, @Param("selective") LumchineUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    List<LumchineUser> selectByExampleSelective(@Param("example") LumchineUserExample example, @Param("selective") LumchineUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    List<LumchineUser> selectByExample(LumchineUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    LumchineUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    LumchineUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    LumchineUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineUser record, @Param("example") LumchineUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineUser record, @Param("example") LumchineUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_user
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}