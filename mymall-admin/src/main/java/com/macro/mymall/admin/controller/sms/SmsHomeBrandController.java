package com.macro.mymall.admin.controller.sms;

import com.macro.domain.model.sms.SmsHomeBrand;
import com.macro.mymall.admin.common.CommonPage;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.service.SmsHomeBrandService;
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
@Api(tags = "SmsHomeBrandController", description = "品牌推荐管理")
@Controller
@RequestMapping("home/brand")
public class SmsHomeBrandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsHomeBrandController.class);

    @Autowired
    private SmsHomeBrandService brandService;

    @ApiOperation("分页查询品牌推荐列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsHomeBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<SmsHomeBrand> brandList = brandService.listHomeBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("添加品牌推荐")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createHomeBrand(@RequestBody SmsHomeBrand homeBrand) {
        CommonResult commonResult;
        int count = brandService.createHomeBrand(homeBrand);
        if (count == 1) {
            commonResult = CommonResult.success(homeBrand);
            LOGGER.debug("createHomeBrand success:{}", homeBrand);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("createHomeBrand fail:{}", homeBrand);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id品牌推荐信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateHomeBrand(@PathVariable("id") Long id, @RequestBody SmsHomeBrand homeBrand) {
        CommonResult commonResult;
        int count = brandService.updateHomeBrand(id, homeBrand);
        if (count == 1) {
            commonResult = CommonResult.success(homeBrand);
            LOGGER.debug("updateHomeBrand success:{}", homeBrand);
        } else {
            commonResult = CommonResult.fail("操作失败");
            LOGGER.debug("updateHomeBrand fail:{}", homeBrand);
        }
        return commonResult;
    }


    @ApiOperation("删除指定id的品牌推荐")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteHomeBrand(@PathVariable("id") Long id) {
        int count = brandService.deleteHomeBrand(id);
        if (count == 1) {
            LOGGER.debug("deleteHomeBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteHomeBrand fail :id={}", id);
            return CommonResult.fail("操作失败");
        }
    }

}
