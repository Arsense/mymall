package com.macro.mymall.admin.service.impl.sms;

import com.github.pagehelper.PageHelper;
import com.macro.domain.model.sms.SmsHomeRecommendProductExample;
import com.macro.domain.model.sms.SmsHomeRecommendSubjectExample;
import com.macro.domain.model.sms.SmsHomeRecommendSubject;
import com.macro.domain.model.sms.SmsHomeRecommendSubjectExample;
import com.macro.mapper.SmsHomeRecommendSubjectMapper;
import com.macro.mymall.admin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:04
 */
@Service
public class SmsHomeRecommendSubjectServiceImpl implements SmsHomeRecommendSubjectService {


    @Autowired
    private SmsHomeRecommendSubjectMapper recommendSubjectMapper;
    
    @Override
    public List<SmsHomeRecommendSubject> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return recommendSubjectMapper.selectByExample(new SmsHomeRecommendSubjectExample());
    }
    
    @Override
    public int createHomeRecommendSubject(SmsHomeRecommendSubject recommendSubject) {
        return recommendSubjectMapper.insert(recommendSubject);
    }


    @Override
    public int updateHomeRecommendSubject(Long id, SmsHomeRecommendSubject recommendSubject) {
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        example.createCriteria().andIdEqualTo(id);
        return recommendSubjectMapper.updateByExample(recommendSubject, example);
    }

    @Override
    public int deleteHomeRecommendSubject(Long id) {
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        example.createCriteria().andIdEqualTo(id);
        return recommendSubjectMapper.deleteByExample(example);
    }
}
