package com.macro.mymall.admin.controller.sms;

import com.macro.domain.model.sms.SmsHomeNewProduct;
import com.macro.mymall.admin.common.CommonPage;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.service.SmsHomeNewProductService;
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
@Api(tags = "SmsHomeNewProductController", description = "人气推荐管理")
@Controller
@RequestMapping("home/newProduct")
public class SmsHomeNewProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsHomeNewProductController.class);

    @Autowired
    private SmsHomeNewProductService newProductService;

    @ApiOperation("分页查询人气推荐列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsHomeNewProduct>> listNewProduct(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                 @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<SmsHomeNewProduct> newProductList = newProductService.listNewProduct(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(newProductList));
    }



    @ApiOperation("添加人气推荐")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createNewProduct(@RequestBody SmsHomeNewProduct newProduct) {
        CommonResult commonResult;
        int count = newProductService.createNewProduct(newProduct);
        if (count == 1) {
            commonResult = CommonResult.success(newProduct);
            LOGGER.debug("createNewProduct success:{}", newProduct);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("createNewProduct fail:{}", newProduct);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id人气推荐信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateNewProduct(@PathVariable("id") Long id, @RequestBody SmsHomeNewProduct newProduct) {
        CommonResult commonResult;
        int count = newProductService.updateNewProduct(id, newProduct);
        if (count == 1) {
            commonResult = CommonResult.success(newProduct);
            LOGGER.debug("updateNewProduct success:{}", newProduct);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("updateNewProduct fail:{}", newProduct);
        }
        return commonResult;
    }


    @ApiOperation("删除指定id的人气推荐")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteNewProduct(@PathVariable("id") Long id) {
        int count = newProductService.deleteNewProduct(id);
        if (count == 1) {
            LOGGER.debug("deleteNewProduct success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteNewProduct fail :id={}", id);
            return CommonResult.fail("操作失败");
        }
    }




}
