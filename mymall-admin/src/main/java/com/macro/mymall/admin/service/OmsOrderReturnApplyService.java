package com.macro.mymall.admin.service;

import com.macro.domain.model.oms.OmsOrderReturnApply;
import com.macro.mymall.admin.request.OmsReturnApplyQueryParam;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/29 19:51
 */
public interface OmsOrderReturnApplyService {
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);
}
