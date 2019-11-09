package com.macro.mymall.admin.service.impl.oms;

import com.github.pagehelper.PageHelper;
import com.macro.domain.model.oms.OmsOrder;
import com.macro.domain.model.oms.OmsOrderExample;
import com.macro.mapper.OmsOrderDao;
import com.macro.mapper.OmsOrderMapper;
import com.macro.domain.model.oms.OmsOrderDetail;
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

    @Autowired
    private OmsOrderDao orderDao;

    @Override
    public List<OmsOrder> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        OmsOrderExample example = new OmsOrderExample();

        return omsOrderMapper.selectByExample(example);
    }

    @Override
    public OmsOrderDetail detail(Long id) {
        return null;
    }
}
