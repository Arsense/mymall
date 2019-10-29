package com.macro.mymall.admin.controller.oms;

import com.macro.domain.model.oms.OmsOrderSetting;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.service.OmsOrderSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author clay
 * @date 2019/10/29 19:33
 */
@Controller
@Api(tags = "OmsOrderSettingController", description = "订单设置管理")
@RequestMapping("/orderSetting")
public class OmsOrderSettingController {

        @Autowired
        private OmsOrderSettingService omsOrderSettingService;

        @ApiOperation("获取指定订单设置")
        @RequestMapping("/{id}")
        @ResponseBody
        public CommonResult getOrderSetting(@PathVariable Long id) {
            OmsOrderSetting setting = omsOrderSettingService.getItem(id);

            return CommonResult.success(setting);
        }




}
