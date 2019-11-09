package com.macro.mymall.admin.controller.sms;

import com.macro.domain.model.sms.SmsFlashPromotion;
import com.macro.mymall.admin.common.CommonPage;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.service.SmsFlashPromotionService;
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
@Api(tags = "SmsFlashPromotionController", description = "限时购活动管理")
@Controller
@RequestMapping("/flash")
public class SmsFlashPromotionController {
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsFlashPromotionController.class);
    
    @Autowired
    private SmsFlashPromotionService smsFlashPromotionService;
    
    
    @ApiOperation("分页查询限时购活动列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsFlashPromotion>> listFlashPromotion(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                 @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<SmsFlashPromotion> flashPromotions = smsFlashPromotionService.listFlashPromotion(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(flashPromotions));
    }

    @ApiOperation("添加限时购活动")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createFlashPromotion(@RequestBody SmsFlashPromotion SmsFlashPromotion) {
        CommonResult commonResult;
        int count = smsFlashPromotionService.createFlashPromotion(SmsFlashPromotion);
        if (count == 1) {
            commonResult = CommonResult.success(SmsFlashPromotion);
            LOGGER.debug("createFlashPromotion success:{}", SmsFlashPromotion);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("createFlashPromotion fail:{}", SmsFlashPromotion);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id限时购活动信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateFlashPromotion(@PathVariable("id") Long id, @RequestBody SmsFlashPromotion flashPromotion) {
        CommonResult commonResult;
        int count = smsFlashPromotionService.updateFlashPromotion(id, flashPromotion);
        if (count == 1) {
            commonResult = CommonResult.success(flashPromotion);
            LOGGER.debug("updateFlashPromotion success:{}", flashPromotion);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("updateFlashPromotion fail:{}", flashPromotion);
        }
        return commonResult;
    }


    @ApiOperation("删除指定id的限时购活动")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteFlashPromotion(@PathVariable("id") Long id) {
        int count = smsFlashPromotionService.deleteFlashPromotion(id);
        if (count == 1) {
            LOGGER.debug("deleteFlashPromotion success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteFlashPromotion fail :id={}", id);
            return CommonResult.fail("操作失败");
        }
    }



}
