package com.macro.mapper;

import com.macro.domain.model.oms.OmsOrderDetail;
import org.apache.ibatis.annotations.Param;


/**
 * @author clay
 * @date 2019/10/30 11:31
 */
public interface OmsOrderDao {
    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);

}
