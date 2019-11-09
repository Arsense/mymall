package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.sms.SmsHomeNewProduct;
import com.macro.mymall.admin.service.SmsHomeNewProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:04
 */
@Service
public class SmsHomeNewProductServiceImpl implements SmsHomeNewProductService {

    @Override
    public int deleteNewProduct(Long id) {
        return 0;
    }

    @Override
    public int updateNewProduct(Long id, SmsHomeNewProduct newProduct) {
        return 0;
    }

    @Override
    public int createNewProduct(SmsHomeNewProduct newProduct) {
        return 0;
    }

    @Override
    public List<SmsHomeNewProduct> listNewProduct(Integer pageNum, Integer pageSize) {
        return new ArrayList<>();
    }
}
