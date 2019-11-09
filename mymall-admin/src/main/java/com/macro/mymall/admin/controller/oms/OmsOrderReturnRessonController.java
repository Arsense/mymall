package com.macro.mymall.admin.controller.oms;

import com.macro.domain.model.oms.OmsOrderReturnReason;
import com.macro.mymall.admin.common.CommonPage;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.request.OmsReturnApplyQueryParam;
import com.macro.mymall.admin.service.OmsOrderReturnRessonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/29 20:00
 */
@Controller
@Api(tags = "OmsOrderReturnRessonController", description = "订单退货原因管理")
@RequestMapping("/returnReason")
public class OmsOrderReturnRessonController {

    @Autowired
    private OmsOrderReturnRessonService returnRessonService;

    @ApiOperation("分页查询退货原因")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrderReturnReason>> list(OmsReturnApplyQueryParam queryParam,
                                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrderReturnReason> returnReasonList = returnRessonService.list(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(returnReasonList));
    }



    @ApiOperation("添加退货原因")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody OmsOrderReturnReason returnReason) {
//        int count = returnRessonService.create(returnReason);
//        if (count > 0) {
//            return CommonResult.success(count);
//        }
        return CommonResult.fail();
    }

    @ApiOperation("批量删除退货原因")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
//        int count = returnRessonService.delete(ids);
//        if (count > 0) {
//            return CommonResult.success(count);
//        }
        return CommonResult.fail();
    }

    @ApiOperation("修改退货原因")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody OmsOrderReturnReason returnReason) {


        return CommonResult.fail();
    }





}
