package com.lumchine.admin.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.lumchine.db.domain.LumchineCoupon;
import com.lumchine.db.domain.LumchineCouponUser;
import com.lumchine.db.service.LumchineCouponService;
import com.lumchine.db.service.LumchineCouponUserService;
import com.lumchine.db.util.CouponConstant;
import com.lumchine.db.util.CouponUserConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 检测优惠券过期情况
 */
@Component
public class CouponJob {
    private final Log logger = LogFactory.getLog(CouponJob.class);

    @Autowired
    private LumchineCouponService couponService;
    @Autowired
    private LumchineCouponUserService couponUserService;

    /**
     * 每隔一个小时检查
     * TODO
     * 注意，因为是相隔一个小时检查，因此导致优惠券真正超时时间可能比设定时间延迟1个小时
     */
    @Scheduled(fixedDelay = 60 * 60 * 1000)
    public void checkCouponExpired() {
        logger.info("系统开启任务检查优惠券是否已经过期");

        List<LumchineCoupon> couponList = couponService.queryExpired();
        for (LumchineCoupon coupon : couponList) {
            coupon.setStatus(CouponConstant.STATUS_EXPIRED);
            couponService.updateById(coupon);
        }

        List<LumchineCouponUser> couponUserList = couponUserService.queryExpired();
        for (LumchineCouponUser couponUser : couponUserList) {
            couponUser.setStatus(CouponUserConstant.STATUS_EXPIRED);
            couponUserService.update(couponUser);
        }
    }

}
