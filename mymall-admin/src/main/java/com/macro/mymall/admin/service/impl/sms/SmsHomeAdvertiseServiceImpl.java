package com.macro.mymall.admin.service.impl.sms;

import com.github.pagehelper.PageHelper;
import com.macro.domain.model.sms.SmsCouponExample;
import com.macro.domain.model.sms.SmsHomeAdvertise;
import com.macro.domain.model.sms.SmsHomeAdvertiseExample;
import com.macro.mapper.SmsHomeAdvertiseMapper;
import com.macro.mymall.admin.service.SmsHomeAdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:03
 */
@Service
public class SmsHomeAdvertiseServiceImpl implements SmsHomeAdvertiseService {


    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;

    @Override
    public List<SmsHomeAdvertise> listAdvertise(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return advertiseMapper.selectByExample(new SmsHomeAdvertiseExample());
    }


    @Override
    public int deleteAdvertise(Long id) {
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        example.createCriteria().andIdEqualTo(id);
        return advertiseMapper.deleteByExample(example);
    }

    @Override
    public int updateAdvertise(Long id, SmsHomeAdvertise advertise) {
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        example.createCriteria().andIdEqualTo(id);
        return advertiseMapper.updateByExample(advertise, example);
    }

    @Override
    public int createAdvertise(SmsHomeAdvertise advertise) {
        return advertiseMapper.insert(advertise);

    }


}
