package com.lumchine.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.lumchine.db.dao.LumchineCouponMapper;
import com.lumchine.db.dao.LumchineCouponUserMapper;
import com.lumchine.db.domain.LumchineCoupon;
import com.lumchine.db.domain.LumchineCouponExample;
import com.lumchine.db.domain.LumchineCouponUser;
import com.lumchine.db.domain.LumchineCouponUserExample;
import com.lumchine.db.util.CouponConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class LumchineCouponService {
    @Resource
    private LumchineCouponMapper couponMapper;
    @Resource
    private LumchineCouponUserMapper couponUserMapper;

    private LumchineCoupon.Column[] result = new LumchineCoupon.Column[]{LumchineCoupon.Column.id, LumchineCoupon.Column.name, LumchineCoupon.Column.desc, LumchineCoupon.Column.tag,
                                            LumchineCoupon.Column.days, LumchineCoupon.Column.startTime, LumchineCoupon.Column.endTime,
                                            LumchineCoupon.Column.discount, LumchineCoupon.Column.min};

    /**
     * 查询，空参数
     *
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    public List<LumchineCoupon> queryList(int offset, int limit, String sort, String order) {
        return queryList(LumchineCouponExample.newAndCreateCriteria(), offset, limit, sort, order);
    }

    /**
     * 查询
     *
     * @param criteria 可扩展的条件
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    public List<LumchineCoupon> queryList(LumchineCouponExample.Criteria criteria, int offset, int limit, String sort, String order) {
        criteria.andTypeEqualTo(CouponConstant.TYPE_COMMON).andStatusEqualTo(CouponConstant.STATUS_NORMAL).andDeletedEqualTo(false);
        criteria.example().setOrderByClause(sort + " " + order);
        PageHelper.startPage(offset, limit);
        return couponMapper.selectByExampleSelective(criteria.example(), result);
    }

    public List<LumchineCoupon> queryAvailableList(Integer userId, int offset, int limit) {
        assert userId != null;
        // 过滤掉登录账号已经领取过的coupon
        LumchineCouponExample.Criteria c = LumchineCouponExample.newAndCreateCriteria();
        List<LumchineCouponUser> used = couponUserMapper.selectByExample(
                LumchineCouponUserExample.newAndCreateCriteria().andUserIdEqualTo(userId).example()
        );
        if(used!=null && !used.isEmpty()){
            c.andIdNotIn(used.stream().map(LumchineCouponUser::getCouponId).collect(Collectors.toList()));
        }
        return queryList(c, offset, limit, "add_time", "desc");
    }

    public List<LumchineCoupon> queryList(int offset, int limit) {
        return queryList(offset, limit, "add_time", "desc");
    }

    public LumchineCoupon findById(Integer id) {
        return couponMapper.selectByPrimaryKey(id);
    }


    public LumchineCoupon findByCode(String code) {
        LumchineCouponExample example = new LumchineCouponExample();
        example.or().andCodeEqualTo(code).andTypeEqualTo(CouponConstant.TYPE_CODE).andStatusEqualTo(CouponConstant.STATUS_NORMAL).andDeletedEqualTo(false);
        List<LumchineCoupon> couponList =  couponMapper.selectByExample(example);
        if(couponList.size() > 1){
            throw new RuntimeException("");
        }
        else if(couponList.size() == 0){
            return null;
        }
        else {
            return couponList.get(0);
        }
    }

    /**
     * 查询新用户注册优惠券
     *
     * @return
     */
    public List<LumchineCoupon> queryRegister() {
        LumchineCouponExample example = new LumchineCouponExample();
        example.or().andTypeEqualTo(CouponConstant.TYPE_REGISTER).andStatusEqualTo(CouponConstant.STATUS_NORMAL).andDeletedEqualTo(false);
        return couponMapper.selectByExample(example);
    }

    public List<LumchineCoupon> querySelective(String name, Short type, Short status, Integer page, Integer limit, String sort, String order) {
        LumchineCouponExample example = new LumchineCouponExample();
        LumchineCouponExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return couponMapper.selectByExample(example);
    }

    public void add(LumchineCoupon coupon) {
        coupon.setAddTime(LocalDateTime.now());
        coupon.setUpdateTime(LocalDateTime.now());
        couponMapper.insertSelective(coupon);
    }

    public int updateById(LumchineCoupon coupon) {
        coupon.setUpdateTime(LocalDateTime.now());
        return couponMapper.updateByPrimaryKeySelective(coupon);
    }

    public void deleteById(Integer id) {
        couponMapper.logicalDeleteByPrimaryKey(id);
    }

    private String getRandomNum(Integer num) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        base += "0123456789";

        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成优惠码
     *
     * @return 可使用优惠码
     */
    public String generateCode() {
        String code = getRandomNum(8);
        while(findByCode(code) != null){
            code = getRandomNum(8);
        }
        return code;
    }

    /**
     * 查询过期的优惠券:
     * 注意：如果timeType=0, 即基于领取时间有效期的优惠券，则优惠券不会过期
     *
     * @return
     */
    public List<LumchineCoupon> queryExpired() {
        LumchineCouponExample example = new LumchineCouponExample();
        example.or().andStatusEqualTo(CouponConstant.STATUS_NORMAL).andTimeTypeEqualTo(CouponConstant.TIME_TYPE_TIME).andEndTimeLessThan(LocalDateTime.now()).andDeletedEqualTo(false);
        return couponMapper.selectByExample(example);
    }
}
