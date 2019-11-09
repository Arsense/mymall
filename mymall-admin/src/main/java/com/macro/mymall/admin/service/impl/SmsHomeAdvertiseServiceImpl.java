package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.sms.SmsHomeAdvertise;
import com.macro.mymall.admin.service.SmsHomeAdvertiseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:03
 */
@Service
public class SmsHomeAdvertiseServiceImpl implements SmsHomeAdvertiseService {

    @Override
    public int deleteAdvertise(Long id) {
        return 0;
    }

    @Override
    public int updateAdvertise(Long id, SmsHomeAdvertise advertise) {
        return 0;
    }

    @Override
    public int createAdvertise(SmsHomeAdvertise advertise) {
        return 0;
    }

    @Override
    public List<SmsHomeAdvertise> listAdvertise(Integer pageNum, Integer pageSize) {
        return new ArrayList<>();
    }
}
