package com.macro.mymall.admin.service;

import com.macro.domain.model.sms.SmsHomeNewProduct;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:02
 */
public interface SmsHomeNewProductService {
    int deleteNewProduct(Long id);

    int updateNewProduct(Long id, SmsHomeNewProduct newProduct);

    int createNewProduct(SmsHomeNewProduct newProduct);

    List<SmsHomeNewProduct> listNewProduct(Integer pageNum, Integer pageSize);
}
