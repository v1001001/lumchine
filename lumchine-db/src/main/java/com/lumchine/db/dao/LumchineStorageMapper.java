package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineStorage;
import com.lumchine.db.domain.LumchineStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineStorageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    long countByExample(LumchineStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    int insert(LumchineStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    int insertSelective(LumchineStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    LumchineStorage selectOneByExample(LumchineStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    LumchineStorage selectOneByExampleSelective(@Param("example") LumchineStorageExample example, @Param("selective") LumchineStorage.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    List<LumchineStorage> selectByExampleSelective(@Param("example") LumchineStorageExample example, @Param("selective") LumchineStorage.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    List<LumchineStorage> selectByExample(LumchineStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    LumchineStorage selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineStorage.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    LumchineStorage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    LumchineStorage selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineStorage record, @Param("example") LumchineStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineStorage record, @Param("example") LumchineStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_storage
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}