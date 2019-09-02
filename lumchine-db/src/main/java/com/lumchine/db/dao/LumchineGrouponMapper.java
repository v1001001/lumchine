package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineGroupon;
import com.lumchine.db.domain.LumchineGrouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineGrouponMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    long countByExample(LumchineGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    int insert(LumchineGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    int insertSelective(LumchineGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    LumchineGroupon selectOneByExample(LumchineGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    LumchineGroupon selectOneByExampleSelective(@Param("example") LumchineGrouponExample example, @Param("selective") LumchineGroupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    List<LumchineGroupon> selectByExampleSelective(@Param("example") LumchineGrouponExample example, @Param("selective") LumchineGroupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    List<LumchineGroupon> selectByExample(LumchineGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    LumchineGroupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineGroupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    LumchineGroupon selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    LumchineGroupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineGroupon record, @Param("example") LumchineGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineGroupon record, @Param("example") LumchineGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_groupon
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}