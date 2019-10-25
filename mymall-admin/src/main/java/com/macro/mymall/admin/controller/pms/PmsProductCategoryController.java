package com.macro.mymall.admin.controller.pms;

import com.macro.domain.model.pms.PmsProductCategoryWithChildrenItem;
import com.macro.mymall.admin.common.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangwei
 * @date 2019/10/22 18:29
 */
@Controller
@Api(tags = "PmsProductCategoryController", description = "商品分类管理")
@RequestMapping("/productCategory")
public class PmsProductCategoryController {


    @ApiOperation("查询所有一级分类及子分类")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductCategoryWithChildrenItem>> listWithChildren() {
//        List<PmsProductCategoryWithChildrenItem> list = productCategoryService.listWithChildren();
        List<PmsProductCategoryWithChildrenItem> list = new ArrayList<>();
        PmsProductCategoryWithChildrenItem item = new PmsProductCategoryWithChildrenItem();

        item.setId(1L);
        item.setName("测试子分类");

        return CommonResult.success(new ArrayList<>());
    }





}
