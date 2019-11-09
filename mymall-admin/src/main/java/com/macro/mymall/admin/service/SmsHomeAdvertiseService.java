package com.macro.mymall.admin.service;

import com.macro.domain.model.sms.SmsHomeAdvertise;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:02
 */
public interface SmsHomeAdvertiseService {
    int deleteAdvertise(Long id);

    int updateAdvertise(Long id, SmsHomeAdvertise advertise);

    int createAdvertise(SmsHomeAdvertise advertise);

    List<SmsHomeAdvertise> listAdvertise(Integer pageNum, Integer pageSize);
}
