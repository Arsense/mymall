package com.macro.mymall.admin.service.impl.sms;

import com.github.pagehelper.PageHelper;
import com.macro.domain.model.sms.SmsHomeBrandExample;
import com.macro.domain.model.sms.SmsHomeBrand;
import com.macro.domain.model.sms.SmsHomeBrandExample;
import com.macro.mapper.SmsHomeBrandMapper;
import com.macro.mymall.admin.service.SmsHomeBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:04
 */
@Service
public class SmsHomeBrandServiceImpl implements SmsHomeBrandService {

    
    @Autowired
    private SmsHomeBrandMapper brandMapper;
    
    @Override
    public int deleteHomeBrand(Long id) {
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        example.createCriteria().andIdEqualTo(id);
        return brandMapper.deleteByExample(example);
    }

    @Override
    public int updateHomeBrand(Long id, SmsHomeBrand homeBrand) {
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        example.createCriteria().andIdEqualTo(id);
        return brandMapper.updateByExample(homeBrand, example);
    }

    @Override
    public int createHomeBrand(SmsHomeBrand homeBrand) {
        return brandMapper.insert(homeBrand);
    }

    @Override
    public List<SmsHomeBrand> listHomeBrand(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new SmsHomeBrandExample());
    }
}
