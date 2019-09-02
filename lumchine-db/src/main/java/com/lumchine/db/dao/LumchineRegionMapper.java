package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineRegion;
import com.lumchine.db.domain.LumchineRegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineRegionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    long countByExample(LumchineRegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineRegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    int insert(LumchineRegion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    int insertSelective(LumchineRegion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    LumchineRegion selectOneByExample(LumchineRegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    LumchineRegion selectOneByExampleSelective(@Param("example") LumchineRegionExample example, @Param("selective") LumchineRegion.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    List<LumchineRegion> selectByExampleSelective(@Param("example") LumchineRegionExample example, @Param("selective") LumchineRegion.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    List<LumchineRegion> selectByExample(LumchineRegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    LumchineRegion selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineRegion.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    LumchineRegion selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineRegion record, @Param("example") LumchineRegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineRegion record, @Param("example") LumchineRegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineRegion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_region
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineRegion record);
}