package com.macro.mymall.admin.controller.oms;

import com.macro.mymall.admin.service.OmsOrderSettingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tangwei
 * @date 2019/10/29 19:33
 */
@Controller
@Api(tags = "OmsOrderSettingController", description = "订单设置管理")
@RequestMapping("/orderSetting")
public class OmsOrderSettingController {

        @Autowired
        private OmsOrderSettingService omsOrderSettingService;





}
