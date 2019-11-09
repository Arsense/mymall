package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.sms.SmsHomeRecommendSubject;
import com.macro.mymall.admin.service.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:04
 */
@Service
public class SmsHomeRecommendSubjectServiceImpl implements SmsHomeRecommendSubjectService {


    @Override
    public int createHomeRecommendSubject(SmsHomeRecommendSubject smsHomeRecommendSubject) {
        return 0;
    }

    @Override
    public List<SmsHomeRecommendSubject> list(Integer pageNum, Integer pageSize) {
        return new ArrayList<>();
    }

    @Override
    public int updateHomeRecommendSubject(Long id, SmsHomeRecommendSubject smsHomeRecommendSubjectDto) {
        return 0;
    }

    @Override
    public int deleteHomeRecommendSubject(Long id) {
        return 0;
    }
}
