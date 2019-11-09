package com.macro.mymall.admin.service.impl.oms;

import com.github.pagehelper.PageHelper;
import com.macro.domain.model.oms.OmsOrderReturnReason;
import com.macro.domain.model.oms.OmsOrderReturnReasonExample;
import com.macro.mapper.OmsOrderReturnReasonMapper;
import com.macro.mymall.admin.service.OmsOrderReturnRessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 订单原因管理Service实现类
 *
 * @author clay
 * @date 2019/10/29 20:01
 */
@Service
public class OmsOrderReturnRessonServiceImpl implements OmsOrderReturnRessonService {

    @Autowired
    private OmsOrderReturnReasonMapper returnReasonMapper;

    @Override
    public List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
        example.setOrderByClause("sort desc");
        return returnReasonMapper.selectByExample(example);
    }
}
