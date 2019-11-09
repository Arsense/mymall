package com.macro.mymall.admin.service;

import com.macro.domain.model.sms.SmsFlashPromotion;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:02
 */
public interface SmsFlashPromotionService {
    List<SmsFlashPromotion> listFlashPromotion(Integer pageNum, Integer pageSize);

    int createFlashPromotion(SmsFlashPromotion smsFlashPromotion);

    int updateFlashPromotion(Long id, SmsFlashPromotion flashPromotion);

    int deleteFlashPromotion(Long id);
}
