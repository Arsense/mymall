package com.macro.mymall.admin.service;

import com.macro.domain.model.oms.OmsOrder;
import com.macro.domain.model.oms.OmsOrderDetail;

import java.util.List;

/**
 *
 * 订单服务
 * @author clay
 * @date 2019/10/29 18:30
 */
public interface OmsOrderService {

    /**
     * 分页查询订单
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<OmsOrder> list(Integer pageNum, Integer pageSize);

    OmsOrderDetail detail(Long id);
}
