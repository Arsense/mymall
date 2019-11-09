package com.macro.mymall.admin.controller.sms;

import com.macro.domain.model.sms.SmsHomeRecommendSubject;
import com.macro.mymall.admin.common.CommonPage;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.service.SmsHomeRecommendSubjectService;
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
 * @date 2019/11/9 21:08
 */
@Api(tags = "SmsHomeRecommendSubjectController", description = "专题管理")
@Controller
@RequestMapping("home/recommendSubject")
public class SmsHomeRecommendSubjectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsHomeRecommendSubjectController.class);
    
    @Autowired
    private SmsHomeRecommendSubjectService recommendSubjectService;

    @ApiOperation("分页查询专题列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsHomeRecommendSubject>> listHomeRecommendSubject(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                       @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<SmsHomeRecommendSubject> recommendSubjectList = recommendSubjectService.list(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(recommendSubjectList));
    }

    @ApiOperation("添加专题")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createHomeRecommendSubject(@RequestBody SmsHomeRecommendSubject recommendSubject) {
        CommonResult commonResult;
        int count = recommendSubjectService.createHomeRecommendSubject(recommendSubject);
        if (count == 1) {
            commonResult = CommonResult.success(recommendSubject);
            LOGGER.debug("createHomeRecommendSubject success:{}", recommendSubject);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("createHomeRecommendSubject fail:{}", recommendSubject);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id专题信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateHomeRecommendSubject(@PathVariable("id") Long id, @RequestBody SmsHomeRecommendSubject recommendSubject, BindingResult result) {
        CommonResult commonResult;
        int count = recommendSubjectService.updateHomeRecommendSubject(id, recommendSubject);
        if (count == 1) {
            commonResult = CommonResult.success(recommendSubject);
            LOGGER.debug("updateHomeRecommendSubject success:{}", recommendSubject);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("updateHomeRecommendSubject fail:{}", recommendSubject);
        }
        return commonResult;
    }


    @ApiOperation("删除指定id的专题")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteHomeRecommendSubject(@PathVariable("id") Long id) {
        int count = recommendSubjectService.deleteHomeRecommendSubject(id);
        if (count == 1) {
            LOGGER.debug("deleteHomeRecommendSubject success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteHomeRecommendSubject fail :id={}", id);
            return CommonResult.fail("操作失败");
        }
    }


}
