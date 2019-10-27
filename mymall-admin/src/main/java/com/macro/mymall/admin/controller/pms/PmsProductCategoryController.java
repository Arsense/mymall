package com.macro.mymall.admin.controller.pms;

import com.macro.domain.model.pms.PmsProductCategory;
import com.macro.domain.model.pms.PmsProductCategoryWithChildrenItem;
import com.macro.mymall.admin.common.CommonPage;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.service.PmsProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private PmsProductCategoryService productCategoryService;


    @ApiOperation("查询所有一级分类及子分类")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductCategoryWithChildrenItem>> listWithChildren() {
//        List<PmsProductCategoryWithChildrenItem> list = productCategoryService.listWithChildren();
        List<PmsProductCategoryWithChildrenItem> list = new ArrayList<>();
        PmsProductCategoryWithChildrenItem item = new PmsProductCategoryWithChildrenItem();

        item.setId(1L);
        item.setName("测试一级分类");

        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setId(2L);
        productCategory.setName("测试二级分类");
        item.setChildren(new ArrayList<>());
        item.getChildren().add(productCategory);

        list.add(item);

        return CommonResult.success(list);
    }


    @ApiOperation("分页查询商品分类")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProductCategory>> getList(@PathVariable Long parentId,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProductCategory> productCategoryList = new ArrayList<>();

        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setId(1L);
        productCategory.setName("测试商品分类");
        productCategoryList.add(productCategory);

        return CommonResult.success(CommonPage.restPage(productCategoryList));
    }




    @ApiOperation("根据id获取商品分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsProductCategory> getItem(@PathVariable Long id) {
        PmsProductCategory productCategory = productCategoryService.getItem(id);
        return CommonResult.success(productCategory);
    }



}
