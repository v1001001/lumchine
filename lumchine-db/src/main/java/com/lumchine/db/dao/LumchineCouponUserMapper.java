package com.lumchine.db.dao;

import com.lumchine.db.domain.LumchineCouponUser;
import com.lumchine.db.domain.LumchineCouponUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LumchineCouponUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    long countByExample(LumchineCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    int deleteByExample(LumchineCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    int insert(LumchineCouponUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    int insertSelective(LumchineCouponUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    LumchineCouponUser selectOneByExample(LumchineCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    LumchineCouponUser selectOneByExampleSelective(@Param("example") LumchineCouponUserExample example, @Param("selective") LumchineCouponUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    List<LumchineCouponUser> selectByExampleSelective(@Param("example") LumchineCouponUserExample example, @Param("selective") LumchineCouponUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    List<LumchineCouponUser> selectByExample(LumchineCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    LumchineCouponUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LumchineCouponUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    LumchineCouponUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    LumchineCouponUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LumchineCouponUser record, @Param("example") LumchineCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LumchineCouponUser record, @Param("example") LumchineCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LumchineCouponUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LumchineCouponUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LumchineCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lumchine_coupon_user
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}