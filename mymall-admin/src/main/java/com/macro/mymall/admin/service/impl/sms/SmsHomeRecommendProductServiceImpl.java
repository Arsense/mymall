package com.macro.mymall.admin.service.impl.sms;

import com.github.pagehelper.PageHelper;
import com.macro.domain.model.sms.SmsHomeRecommendProductExample;
import com.macro.domain.model.sms.SmsHomeRecommendProduct;
import com.macro.domain.model.sms.SmsHomeRecommendProductExample;
import com.macro.mapper.SmsHomeRecommendProductMapper;
import com.macro.mymall.admin.service.SmsHomeNewProductService;
import com.macro.mymall.admin.service.SmsHomeRecommendProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:04
 */

@Service
public class SmsHomeRecommendProductServiceImpl implements SmsHomeRecommendProductService {
    
    @Autowired
    private SmsHomeRecommendProductMapper recommendProductMapper;
    
    @Override
    public int deleteRecommendProduct(Long id) {
        SmsHomeRecommendProductExample example = new SmsHomeRecommendProductExample();
        example.createCriteria().andIdEqualTo(id);
        return recommendProductMapper.deleteByExample(example);
    }

    @Override
    public int updateRecommendProduct(Long id, SmsHomeRecommendProduct recommendProduct) {
        SmsHomeRecommendProductExample example = new SmsHomeRecommendProductExample();
        example.createCriteria().andIdEqualTo(id);
        return recommendProductMapper.updateByExample(recommendProduct, example);
    }

    @Override
    public int createRecommendProduct(SmsHomeRecommendProduct recommendProduct){
        return recommendProductMapper.insert(recommendProduct);
    }

    @Override
    public List<SmsHomeRecommendProduct> listRecommendProduct(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return recommendProductMapper.selectByExample(new SmsHomeRecommendProductExample());
    }
}
