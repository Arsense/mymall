package com.macro.mymall.admin.controller.sms;

import com.macro.domain.model.sms.SmsHomeRecommendProduct;
import com.macro.mymall.admin.common.CommonPage;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.service.SmsHomeRecommendProductService;
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
@Api(tags = "SmsHomeRecommendProductController", description = "人气推荐管理")
@Controller
@RequestMapping("home/recommendProduct")
public class SmsHomeRecommendProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsHomeRecommendProductController.class);

    @Autowired
    private SmsHomeRecommendProductService recommendProductService;
    
    @ApiOperation("分页查询人气推荐列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsHomeRecommendProduct>> listRecommendProduct(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                       @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<SmsHomeRecommendProduct> recommendProductList = recommendProductService.listRecommendProduct(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(recommendProductList));
    }


    @ApiOperation("添加人气推荐")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createRecommendProduct(@RequestBody SmsHomeRecommendProduct recommendProduct) {
        CommonResult commonResult;
        int count = recommendProductService.createRecommendProduct(recommendProduct);
        if (count == 1) {
            commonResult = CommonResult.success(recommendProduct);
            LOGGER.debug("createRecommendProduct success:{}", recommendProduct);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("createRecommendProduct fail:{}", recommendProduct);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id人气推荐信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRecommendProduct(@PathVariable("id") Long id, @RequestBody SmsHomeRecommendProduct recommendProduct, BindingResult result) {
        CommonResult commonResult;
        int count = recommendProductService.updateRecommendProduct(id, recommendProduct);
        if (count == 1) {
            commonResult = CommonResult.success(recommendProduct);
            LOGGER.debug("updateRecommendProduct success:{}", recommendProduct);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("updateRecommendProduct fail:{}", recommendProduct);
        }
        return commonResult;
    }


    @ApiOperation("删除指定id的人气推荐")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteRecommendProduct(@PathVariable("id") Long id) {
        int count = recommendProductService.deleteRecommendProduct(id);
        if (count == 1) {
            LOGGER.debug("deleteRecommendProduct success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteRecommendProduct fail :id={}", id);
            return CommonResult.fail("操作失败");
        }
    }


}
