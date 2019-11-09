package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.sms.SmsHomeBrand;
import com.macro.mymall.admin.service.SmsHomeBrandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:04
 */
@Service
public class SmsHomeBrandServiceImpl implements SmsHomeBrandService {

    @Override
    public int deleteHomeBrand(Long id) {
        return 0;
    }

    @Override
    public int updateHomeBrand(Long id, SmsHomeBrand homeBrand) {
        return 0;
    }

    @Override
    public int createHomeBrand(SmsHomeBrand homeBrand) {
        return 0;
    }

    @Override
    public List<SmsHomeBrand> listHomeBrand(Integer pageNum, Integer pageSize) {
        return new ArrayList<>();
    }
}
