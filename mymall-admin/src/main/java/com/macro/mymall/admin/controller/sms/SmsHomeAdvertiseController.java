package com.macro.mymall.admin.controller.sms;

import com.macro.domain.model.sms.SmsHomeAdvertise;
import com.macro.mymall.admin.common.CommonPage;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.service.SmsHomeAdvertiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:07
 */
@Api(tags = "SmsHomeAdvertiseController", description = "广告列表管理")
@Controller
@RequestMapping("/home/advertise")
public class SmsHomeAdvertiseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsHomeAdvertiseController.class);

    @Autowired
    private SmsHomeAdvertiseService advertiseService;
    
    
    @ApiOperation("分页查询广告列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsHomeAdvertise>> listAdvertise(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<SmsHomeAdvertise> advertiseList = advertiseService.listAdvertise(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(advertiseList));
    }

    @ApiOperation("添加广告")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createAdvertise(@RequestBody SmsHomeAdvertise advertise) {
        CommonResult commonResult;
        int count = advertiseService.createAdvertise(advertise);
        if (count == 1) {
            commonResult = CommonResult.success(advertise);
            LOGGER.debug("createAdvertise success:{}", advertise);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("createAdvertise fail:{}", advertise);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id广告信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateAdvertise(@PathVariable("id") Long id, @RequestBody SmsHomeAdvertise advertise) {
        CommonResult commonResult;
        int count = advertiseService.updateAdvertise(id, advertise);
        if (count == 1) {
            commonResult = CommonResult.success(advertise);
            LOGGER.debug("updateAdvertise success:{}", advertise);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("updateAdvertise fail:{}", advertise);
        }
        return commonResult;
    }


    @ApiOperation("删除指定id的广告")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteAdvertise(@PathVariable("id") Long id) {
        int count = advertiseService.deleteAdvertise(id);
        if (count == 1) {
            LOGGER.debug("deleteAdvertise success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteAdvertise fail :id={}", id);
            return CommonResult.fail("操作失败");
        }
    }


}
