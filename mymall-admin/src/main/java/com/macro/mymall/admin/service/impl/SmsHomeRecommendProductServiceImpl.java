package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.sms.SmsHomeRecommendProduct;
import com.macro.mymall.admin.service.SmsHomeNewProductService;
import com.macro.mymall.admin.service.SmsHomeRecommendProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:04
 */

@Service
public class SmsHomeRecommendProductServiceImpl implements SmsHomeRecommendProductService {
    @Override
    public int deleteRecommendProduct(Long id) {
        return 0;
    }

    @Override
    public int updateRecommendProduct(Long id, SmsHomeRecommendProduct recommendProduct) {
        return 0;
    }

    @Override
    public int createRecommendProduct(SmsHomeRecommendProduct recommendProduct) {
        return 0;
    }

    @Override
    public List<SmsHomeRecommendProduct> listRecommendProduct(Integer pageNum, Integer pageSize) {
        return new ArrayList<>();
    }
}
