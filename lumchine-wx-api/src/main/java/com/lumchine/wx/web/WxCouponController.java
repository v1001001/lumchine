package com.lumchine.wx.web;

import com.lumchine.core.util.JacksonUtil;
import com.lumchine.core.util.ResponseUtil;
import com.lumchine.core.validator.Order;
import com.lumchine.core.validator.Sort;
import com.lumchine.db.domain.LumchineCart;
import com.lumchine.db.domain.LumchineCoupon;
import com.lumchine.db.domain.LumchineCouponUser;
import com.lumchine.db.domain.LumchineGrouponRules;
import com.lumchine.db.service.*;
import com.lumchine.db.util.CouponConstant;
import com.lumchine.wx.annotation.LoginUser;
import com.lumchine.wx.util.WxResponseCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.lumchine.wx.vo.CouponVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 优惠券服务
 */
@RestController
@RequestMapping("/wx/coupon")
@Validated
public class WxCouponController {
    private final Log logger = LogFactory.getLog(WxCouponController.class);

    @Autowired
    private LumchineCouponService couponService;
    @Autowired
    private LumchineCouponUserService couponUserService;
    @Autowired
    private LumchineGrouponRulesService grouponRulesService;
    @Autowired
    private LumchineCartService cartService;
    @Autowired
    private CouponVerifyService couponVerifyService;

    /**
     * 优惠券列表
     *
     * @param page
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    @GetMapping("list")
    public Object list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {

        List<LumchineCoupon> couponList = couponService.queryList(page, limit, sort, order);
        return ResponseUtil.okList(couponList);
    }

    /**
     * 个人优惠券列表
     *
     * @param userId
     * @param status
     * @param page
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    @GetMapping("mylist")
    public Object mylist(@LoginUser Integer userId,
                       @NotNull Short status,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        List<LumchineCouponUser> couponUserList = couponUserService.queryList(userId, null, status, page, limit, sort, order);
        List<CouponVo> couponVoList = change(couponUserList);
        return ResponseUtil.okList(couponVoList, couponUserList);
    }

    private List<CouponVo> change(List<LumchineCouponUser> couponList) {
        List<CouponVo> couponVoList = new ArrayList<>(couponList.size());
        for(LumchineCouponUser couponUser : couponList){
            Integer couponId = couponUser.getCouponId();
            LumchineCoupon coupon = couponService.findById(couponId);
            CouponVo couponVo = new CouponVo();
            couponVo.setId(coupon.getId());
            couponVo.setName(coupon.getName());
            couponVo.setDesc(coupon.getDesc());
            couponVo.setTag(coupon.getTag());
            couponVo.setMin(coupon.getMin().toPlainString());
            couponVo.setDiscount(coupon.getDiscount().toPlainString());
            couponVo.setStartTime(couponUser.getStartTime());
            couponVo.setEndTime(couponUser.getEndTime());

            couponVoList.add(couponVo);
        }

        return couponVoList;
    }


    /**
     * 当前购物车下单商品订单可用优惠券
     *
     * @param userId
     * @param cartId
     * @param grouponRulesId
     * @return
     */
    @GetMapping("selectlist")
    public Object selectlist(@LoginUser Integer userId, Integer cartId, Integer grouponRulesId) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        // 团购优惠
        BigDecimal grouponPrice = new BigDecimal(0.00);
        LumchineGrouponRules grouponRules = grouponRulesService.queryById(grouponRulesId);
        if (grouponRules != null) {
            grouponPrice = grouponRules.getDiscount();
        }

        // 商品价格
        List<LumchineCart> checkedGoodsList = null;
        if (cartId == null || cartId.equals(0)) {
            checkedGoodsList = cartService.queryByUidAndChecked(userId);
        } else {
            LumchineCart cart = cartService.findById(cartId);
            if (cart == null) {
                return ResponseUtil.badArgumentValue();
            }
            checkedGoodsList = new ArrayList<>(1);
            checkedGoodsList.add(cart);
        }
        BigDecimal checkedGoodsPrice = new BigDecimal(0.00);
        for (LumchineCart cart : checkedGoodsList) {
            //  只有当团购规格商品ID符合才进行团购优惠
            if (grouponRules != null && grouponRules.getGoodsId().equals(cart.getGoodsId())) {
                checkedGoodsPrice = checkedGoodsPrice.add(cart.getPrice().subtract(grouponPrice).multiply(new BigDecimal(cart.getNumber())));
            } else {
                checkedGoodsPrice = checkedGoodsPrice.add(cart.getPrice().multiply(new BigDecimal(cart.getNumber())));
            }
        }

        // 计算优惠券可用情况
        List<LumchineCouponUser> couponUserList = couponUserService.queryAll(userId);
        List<LumchineCouponUser> availableCouponUserList = new ArrayList<>(couponUserList.size());
        for (LumchineCouponUser couponUser : couponUserList) {
            LumchineCoupon coupon = couponVerifyService.checkCoupon(userId, couponUser.getCouponId(), checkedGoodsPrice);
            if (coupon == null) {
                continue;
            }
            availableCouponUserList.add(couponUser);
        }

        List<CouponVo> couponVoList = change(availableCouponUserList);

        return ResponseUtil.okList(couponVoList);
    }

    /**
     * 优惠券领取
     *
     * @param userId 用户ID
     * @param body 请求内容， { couponId: xxx }
     * @return 操作结果
     */
    @PostMapping("receive")
    public Object receive(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        Integer couponId = JacksonUtil.parseInteger(body, "couponId");
        if(couponId == null){
            return ResponseUtil.badArgument();
        }

        LumchineCoupon coupon = couponService.findById(couponId);
        if(coupon == null){
            return ResponseUtil.badArgumentValue();
        }

        // 当前已领取数量和总数量比较
        Integer total = coupon.getTotal();
        Integer totalCoupons = couponUserService.countCoupon(couponId);
        if((total != 0) && (totalCoupons >= total)){
            return ResponseUtil.fail(WxResponseCode.COUPON_EXCEED_LIMIT, "优惠券已领完");
        }

        // 当前用户已领取数量和用户限领数量比较
        Integer limit = coupon.getLimit().intValue();
        Integer userCounpons = couponUserService.countUserAndCoupon(userId, couponId);
        if((limit != 0) && (userCounpons >= limit)){
            return ResponseUtil.fail(WxResponseCode.COUPON_EXCEED_LIMIT, "优惠券已经领取过");
        }

        // 优惠券分发类型
        // 例如注册赠券类型的优惠券不能领取
        Short type = coupon.getType();
        if(type.equals(CouponConstant.TYPE_REGISTER)){
            return ResponseUtil.fail(WxResponseCode.COUPON_RECEIVE_FAIL, "新用户优惠券自动发送");
        }
        else if(type.equals(CouponConstant.TYPE_CODE)){
            return ResponseUtil.fail(WxResponseCode.COUPON_RECEIVE_FAIL, "优惠券只能兑换");
        }
        else if(!type.equals(CouponConstant.TYPE_COMMON)){
            return ResponseUtil.fail(WxResponseCode.COUPON_RECEIVE_FAIL, "优惠券类型不支持");
        }

        // 优惠券状态，已下架或者过期不能领取
        Short status = coupon.getStatus();
        if(status.equals(CouponConstant.STATUS_OUT)){
            return ResponseUtil.fail(WxResponseCode.COUPON_EXCEED_LIMIT, "优惠券已领完");
        }
        else if(status.equals(CouponConstant.STATUS_EXPIRED)){
            return ResponseUtil.fail(WxResponseCode.COUPON_RECEIVE_FAIL, "优惠券已经过期");
        }

        // 用户领券记录
        LumchineCouponUser couponUser = new LumchineCouponUser();
        couponUser.setCouponId(couponId);
        couponUser.setUserId(userId);
        Short timeType = coupon.getTimeType();
        if (timeType.equals(CouponConstant.TIME_TYPE_TIME)) {
            couponUser.setStartTime(coupon.getStartTime());
            couponUser.setEndTime(coupon.getEndTime());
        }
        else{
            LocalDateTime now = LocalDateTime.now();
            couponUser.setStartTime(now);
            couponUser.setEndTime(now.plusDays(coupon.getDays()));
        }
        couponUserService.add(couponUser);

        return ResponseUtil.ok();
    }

    /**
     * 优惠券兑换
     *
     * @param userId 用户ID
     * @param body 请求内容， { code: xxx }
     * @return 操作结果
     */
    @PostMapping("exchange")
    public Object exchange(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        String code = JacksonUtil.parseString(body, "code");
        if(code == null){
            return ResponseUtil.badArgument();
        }

        LumchineCoupon coupon = couponService.findByCode(code);
        if(coupon == null){
            return ResponseUtil.fail(WxResponseCode.COUPON_CODE_INVALID, "优惠券不正确");
        }
        Integer couponId = coupon.getId();

        // 当前已领取数量和总数量比较
        Integer total = coupon.getTotal();
        Integer totalCoupons = couponUserService.countCoupon(couponId);
        if((total != 0) && (totalCoupons >= total)){
            return ResponseUtil.fail(WxResponseCode.COUPON_EXCEED_LIMIT, "优惠券已兑换");
        }

        // 当前用户已领取数量和用户限领数量比较
        Integer limit = coupon.getLimit().intValue();
        Integer userCounpons = couponUserService.countUserAndCoupon(userId, couponId);
        if((limit != 0) && (userCounpons >= limit)){
            return ResponseUtil.fail(WxResponseCode.COUPON_EXCEED_LIMIT, "优惠券已兑换");
        }

        // 优惠券分发类型
        // 例如注册赠券类型的优惠券不能领取
        Short type = coupon.getType();
        if(type.equals(CouponConstant.TYPE_REGISTER)){
            return ResponseUtil.fail(WxResponseCode.COUPON_RECEIVE_FAIL, "新用户优惠券自动发送");
        }
        else if(type.equals(CouponConstant.TYPE_COMMON)){
            return ResponseUtil.fail(WxResponseCode.COUPON_RECEIVE_FAIL, "优惠券只能领取，不能兑换");
        }
        else if(!type.equals(CouponConstant.TYPE_CODE)){
            return ResponseUtil.fail(WxResponseCode.COUPON_RECEIVE_FAIL, "优惠券类型不支持");
        }

        // 优惠券状态，已下架或者过期不能领取
        Short status = coupon.getStatus();
        if(status.equals(CouponConstant.STATUS_OUT)){
            return ResponseUtil.fail(WxResponseCode.COUPON_EXCEED_LIMIT, "优惠券已兑换");
        }
        else if(status.equals(CouponConstant.STATUS_EXPIRED)){
            return ResponseUtil.fail(WxResponseCode.COUPON_RECEIVE_FAIL, "优惠券已经过期");
        }

        // 用户领券记录
        LumchineCouponUser couponUser = new LumchineCouponUser();
        couponUser.setCouponId(couponId);
        couponUser.setUserId(userId);
        Short timeType = coupon.getTimeType();
        if (timeType.equals(CouponConstant.TIME_TYPE_TIME)) {
            couponUser.setStartTime(coupon.getStartTime());
            couponUser.setEndTime(coupon.getEndTime());
        }
        else{
            LocalDateTime now = LocalDateTime.now();
            couponUser.setStartTime(now);
            couponUser.setEndTime(now.plusDays(coupon.getDays()));
        }
        couponUserService.add(couponUser);

        return ResponseUtil.ok();
    }
}