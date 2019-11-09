package com.macro.mymall.admin.service;

import com.macro.domain.model.sms.SmsHomeBrand;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:02
 */
public interface SmsHomeBrandService {

    int deleteHomeBrand(Long id);

    int updateHomeBrand(Long id, SmsHomeBrand homeBrand);

    int createHomeBrand(SmsHomeBrand homeBrand);

    List<SmsHomeBrand> listHomeBrand(Integer pageNum, Integer pageSize);
}
