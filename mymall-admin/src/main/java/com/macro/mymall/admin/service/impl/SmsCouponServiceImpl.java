package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.sms.SmsCoupon;
import com.macro.mymall.admin.service.SmsCouponService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:03
 */
@Service
public class SmsCouponServiceImpl implements SmsCouponService {

    @Override
    public List<SmsCoupon> listCoupon(Integer pageNum, Integer pageSize) {
        return new ArrayList<>();

    }

    @Override
    public int createCoupon(SmsCoupon pmsBrand) {
        return 0;
    }

    @Override
    public int updateCoupon(Long id, SmsCoupon pmsBrandDto) {
        return 0;
    }

    @Override
    public int deleteCoupon(Long id) {
        return 0;
    }
}
