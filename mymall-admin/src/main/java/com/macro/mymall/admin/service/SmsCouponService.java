package com.macro.mymall.admin.service;

import com.macro.domain.model.pms.PmsBrand;
import com.macro.domain.model.sms.SmsCoupon;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:02
 */
public interface SmsCouponService {

    List<SmsCoupon> listCoupon(Integer pageNum, Integer pageSize);

    int createCoupon(SmsCoupon pmsBrand);

    int updateCoupon(Long id, SmsCoupon pmsBrandDto);

    int deleteCoupon(Long id);
}
