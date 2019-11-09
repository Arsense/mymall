package com.macro.mymall.admin.service.impl.sms;

import com.github.pagehelper.PageHelper;
import com.macro.domain.model.sms.SmsHomeNewProductExample;
import com.macro.domain.model.sms.SmsHomeNewProduct;
import com.macro.domain.model.sms.SmsHomeNewProductExample;
import com.macro.mapper.SmsHomeNewProductMapper;
import com.macro.mymall.admin.service.SmsHomeNewProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/11/9 21:04
 */
@Service
public class SmsHomeNewProductServiceImpl implements SmsHomeNewProductService {

    @Autowired
    private SmsHomeNewProductMapper newProductMapper;
    
    @Override
    public int deleteNewProduct(Long id) {
        SmsHomeNewProductExample example = new SmsHomeNewProductExample();
        example.createCriteria().andIdEqualTo(id);
        return newProductMapper.deleteByExample(example);
    }

    @Override
    public int updateNewProduct(Long id, SmsHomeNewProduct newProduct) {
        SmsHomeNewProductExample example = new SmsHomeNewProductExample();
        example.createCriteria().andIdEqualTo(id);
        return newProductMapper.updateByExample(newProduct, example);
    }

    @Override
    public int createNewProduct(SmsHomeNewProduct newProduct) {
        return 0;
    }

    @Override
    public List<SmsHomeNewProduct> listNewProduct(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return newProductMapper.selectByExample(new SmsHomeNewProductExample());
    }
}
