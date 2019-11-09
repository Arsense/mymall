package com.macro.domain.model.oms;

import java.util.List;

/**
 * 包含订单商品信息的订单详情
 * @author clay
 * @date 2019/10/30 11:15
 */
public class OmsOrderDetail extends OmsOrder {

    private List<OmsOrderItem> orderItemList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

}
