package com.macro.mymall.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.domain.model.oms.OmsOrder;
import com.macro.domain.model.oms.OmsOrderExample;
import com.macro.mapper.OmsOrderMapper;
import com.macro.mymall.admin.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单服务
 * @author clay
 * @date 2019/10/29 18:31
 */
@Service
public class OmsOrderServiceImpl implements OmsOrderService {


    @Autowired
    private OmsOrderMapper omsOrderMapper;


    @Override
    public List<OmsOrder> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        OmsOrderExample example = new OmsOrderExample();

        return omsOrderMapper.selectByExample(example);
    }
}
