package com.macro.mymall.admin.service.impl.sms;

import com.github.pagehelper.PageHelper;
import com.macro.domain.model.sms.SmsCouponExample;
import com.macro.domain.model.sms.SmsFlashPromotion;
import com.macro.domain.model.sms.SmsFlashPromotionExample;
import com.macro.mapper.SmsFlashPromotionMapper;
import com.macro.mymall.admin.service.SmsFlashPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:03
 */
@Service
public class SmsFlashPromotionServiceImpl implements SmsFlashPromotionService{

    @Autowired
    private SmsFlashPromotionMapper flashPromotionMapper;

    @Override
    public List<SmsFlashPromotion> listFlashPromotion(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return flashPromotionMapper.selectByExample(new SmsFlashPromotionExample());

    }

    @Override
    public int createFlashPromotion(SmsFlashPromotion smsFlashPromotion) {
        return flashPromotionMapper.insert(smsFlashPromotion);

    }

    @Override
    public int updateFlashPromotion(Long id, SmsFlashPromotion flashPromotion) {
        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
        example.createCriteria().andIdEqualTo(id);
        return flashPromotionMapper.updateByExample(flashPromotion, example);

    }

    @Override
    public int deleteFlashPromotion(Long id) {
        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
        example.createCriteria().andIdEqualTo(id);
        return flashPromotionMapper.deleteByExample(example);

    }
}
