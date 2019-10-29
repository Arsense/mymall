package com.macro.mymall.admin.service;

import com.macro.domain.model.oms.OmsOrderReturnReason;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/29 20:01
 */
public interface OmsOrderReturnRessonService {
    List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum);
}
