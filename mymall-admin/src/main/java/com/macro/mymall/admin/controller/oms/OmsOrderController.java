package com.macro.mymall.admin.controller.oms;

import com.macro.domain.model.oms.OmsOrder;
import com.macro.domain.model.oms.OmsOrderDetail;
import com.macro.mymall.admin.common.CommonPage;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author clay
 * @date 2019/10/29 18:29
 */
@Controller
@Api(tags = "OmsOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {


    @Autowired
    private OmsOrderService orderService;


    @ApiOperation("分页查询订单")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrder>> listOrder(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {

        List<OmsOrder> orderList = orderService.list(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(orderList));
    }



    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderDetail> detail(@PathVariable Long id) {
//        OmsOrderDetail orderDetailResult = orderService.detail(id);
        OmsOrderDetail orderDetailResult = new OmsOrderDetail();
        orderDetailResult.setBillContent("内容");
        orderDetailResult.setAutoConfirmDay(1);
        orderDetailResult.setBillHeader("结算头");
        orderDetailResult.setBillReceiverEmail("11@qq.com");
        orderDetailResult.setCommentTime(new Date());

        return CommonResult.success(orderDetailResult);
    }

}
