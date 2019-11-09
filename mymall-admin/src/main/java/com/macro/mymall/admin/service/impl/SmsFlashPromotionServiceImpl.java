package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.sms.SmsFlashPromotion;
import com.macro.mymall.admin.service.SmsFlashPromotionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:03
 */
@Service
public class SmsFlashPromotionServiceImpl implements SmsFlashPromotionService{
    @Override
    public List<SmsFlashPromotion> listFlashPromotion(Integer pageNum, Integer pageSize) {
        return new ArrayList<>();
    }

    @Override
    public int createFlashPromotion(SmsFlashPromotion smsFlashPromotion) {
        return 0;
    }

    @Override
    public int updateFlashPromotion(Long id, SmsFlashPromotion flashPromotion) {
        return 0;
    }

    @Override
    public int deleteFlashPromotion(Long id) {
        return 0;
    }
}
