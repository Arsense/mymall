package com.macro.mymall.admin.service.impl.sms;

import com.github.pagehelper.PageHelper;
import com.macro.domain.model.sms.SmsCoupon;
import com.macro.domain.model.sms.SmsCouponExample;
import com.macro.mapper.SmsCouponMapper;
import com.macro.mymall.admin.service.SmsCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:03
 */
@Service
public class SmsCouponServiceImpl implements SmsCouponService {

    @Autowired
    private SmsCouponMapper couponMapper;

    @Override
    public List<SmsCoupon> listCoupon(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return couponMapper.selectByExample(new SmsCouponExample());

    }

    @Override
    public int createCoupon(SmsCoupon pmsBrand) {
        return couponMapper.insert(pmsBrand);
    }

    @Override
    public int updateCoupon(Long id, SmsCoupon pmsBrandDto) {
        SmsCouponExample example = new SmsCouponExample();
        example.createCriteria().andIdEqualTo(id);
        return couponMapper.updateByExample(pmsBrandDto, example);
    }

    @Override
    public int deleteCoupon(Long id) {
        SmsCouponExample example = new SmsCouponExample();
        example.createCriteria().andIdEqualTo(id);
        return couponMapper.deleteByExample(example);
    }
}
