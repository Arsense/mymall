package com.macro.mymall.admin.controller.oms;

import com.macro.domain.model.oms.OmsOrderReturnApply;
import com.macro.mymall.admin.common.CommonPage;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.request.OmsReturnApplyQueryParam;
import com.macro.mymall.admin.service.OmsOrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/29 19:50
 */

@Controller
@Api(tags = "OmsOrderReturnApplyController", description = "订单退货申请管理")
@RequestMapping("/returnApply")
public class OmsOrderReturnApplyController {

    @Autowired
    private OmsOrderReturnApplyService returnApplyService;

    @ApiOperation("分页查询退货申请")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrderReturnApply>> list(OmsReturnApplyQueryParam queryParam,
                                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrderReturnApply> returnApplyList = returnApplyService.list(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(returnApplyList));
    }




}
