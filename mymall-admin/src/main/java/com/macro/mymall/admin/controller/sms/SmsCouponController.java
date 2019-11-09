package com.macro.mymall.admin.controller.sms;

import com.macro.domain.model.sms.SmsCoupon;
import com.macro.mymall.admin.common.CommonPage;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.service.SmsCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:07
 */

@Api(tags = "SmsCouponController", description = "优惠券管理")
@Controller
@RequestMapping("/coupon")
public class SmsCouponController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsCouponController.class);

    @Autowired
    private SmsCouponService smsCouponService;
    
    
    @ApiOperation("分页查询优惠券列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsCoupon>> listCoupon(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                         @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<SmsCoupon> couponList = smsCouponService.listCoupon(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(couponList));
    }

    @ApiOperation("添加优惠券")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createCoupon(@RequestBody SmsCoupon smsCoupon) {
        CommonResult commonResult;
        int count = smsCouponService.createCoupon(smsCoupon);
        if (count == 1) {
            commonResult = CommonResult.success(smsCoupon);
            LOGGER.debug("createCoupon success:{}", smsCoupon);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("createCoupon fail:{}", smsCoupon);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id优惠券信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateCoupon(@PathVariable("id") Long id, @RequestBody SmsCoupon smsCoupon) {
        CommonResult commonResult;
        int count = smsCouponService.updateCoupon(id, smsCoupon);
        if (count == 1) {
            commonResult = CommonResult.success(smsCoupon);
            LOGGER.debug("updateCoupon success:{}", smsCoupon);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("updateCoupon fail:{}", smsCoupon);
        }
        return commonResult;
    }


    @ApiOperation("删除指定id的优惠券")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteCoupon(@PathVariable("id") Long id) {
        int count = smsCouponService.deleteCoupon(id);
        if (count == 1) {
            LOGGER.debug("deleteCoupon success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteCoupon fail :id={}", id);
            return CommonResult.fail("操作失败");
        }
    }


}
