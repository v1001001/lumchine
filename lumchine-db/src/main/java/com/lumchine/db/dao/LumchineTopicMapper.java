package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineTopic;
import com.lumchine.db.domain.LumchineTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineTopicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    long countByExample(LumchineTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    int insert(LumchineTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    int insertSelective(LumchineTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    LumchineTopic selectOneByExample(LumchineTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    LumchineTopic selectOneByExampleSelective(@Param("example") LumchineTopicExample example, @Param("selective") LumchineTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    LumchineTopic selectOneByExampleWithBLOBs(LumchineTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    List<LumchineTopic> selectByExampleSelective(@Param("example") LumchineTopicExample example, @Param("selective") LumchineTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    List<LumchineTopic> selectByExampleWithBLOBs(LumchineTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    List<LumchineTopic> selectByExample(LumchineTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    LumchineTopic selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    LumchineTopic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    LumchineTopic selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineTopic record, @Param("example") LumchineTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LumchineTopic record, @Param("example") LumchineTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineTopic record, @Param("example") LumchineTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LumchineTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_topic
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}