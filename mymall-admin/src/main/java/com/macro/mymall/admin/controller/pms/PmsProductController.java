package com.macro.mymall.admin.controller.pms;

import com.macro.domain.model.ums.PmsProduct;
import com.macro.mymall.admin.common.CommonPage;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.query.PmsProductQueryParam;
import com.macro.mymall.admin.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 商品管理Controller
 * @author clay
 * @date 2019/10/21 21:07
 */
@Controller
@Api(tags = "PmsProductController", description = "商品管理")
@RequestMapping("/product")
public class PmsProductController {


    @Autowired
    private PmsProductService productService;

    @ApiOperation("查询商品")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProduct>> getList(PmsProductQueryParam productQueryParam,int pageSize, int pageNum){
        List<PmsProduct> productList = productService.list(productQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productList));
    }

}
