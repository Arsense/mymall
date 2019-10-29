package com.macro.mymall.admin.service;

import com.macro.domain.model.oms.OmsOrderSetting;

/**
 * 订单属性设置服务
 * @author clay
 * @date 2019/10/29 19:36
 */
public interface OmsOrderSettingService {

    /**
     * 根据id获取订单的一些延迟等设置属性
     * @param orderId
     * @return
     */
    OmsOrderSetting getItem(Long orderId);
}
