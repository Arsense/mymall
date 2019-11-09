package com.macro.mymall.admin.service;

import com.macro.domain.model.sms.SmsHomeRecommendProduct;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:03
 */
public interface SmsHomeRecommendProductService {
    int deleteRecommendProduct(Long id);

    int updateRecommendProduct(Long id, SmsHomeRecommendProduct recommendProduct);

    int createRecommendProduct(SmsHomeRecommendProduct recommendProduct);

    List<SmsHomeRecommendProduct> listRecommendProduct(Integer pageNum, Integer pageSize);
}
