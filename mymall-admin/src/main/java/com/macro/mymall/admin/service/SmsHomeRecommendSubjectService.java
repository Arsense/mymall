package com.macro.mymall.admin.service;

import com.macro.domain.model.sms.SmsHomeRecommendSubject;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:03
 */
public interface SmsHomeRecommendSubjectService {
    int createHomeRecommendSubject(SmsHomeRecommendSubject smsHomeRecommendSubject);

    List<SmsHomeRecommendSubject> list(Integer pageNum, Integer pageSize);

    int updateHomeRecommendSubject(Long id, SmsHomeRecommendSubject smsHomeRecommendSubjectDto);

    int deleteHomeRecommendSubject(Long id);
}
