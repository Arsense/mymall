package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.ums.PmsProductAttribute;
import com.macro.mymall.admin.query.PmsProductAttributeParam;
import com.macro.mymall.admin.service.PmsProductAttributeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tangwei
 * @date 2019/10/23 14:26
 */
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {


    @Override
    public List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public int delete(List<Long> ids) {
        return 0;
    }

    @Override
    public PmsProductAttribute getItem(Long id) {
        return null;
    }

    @Override
    public int update(Long id, PmsProductAttributeParam productAttributeParam) {
        return 0;
    }

    @Override
    public int create(PmsProductAttributeParam productAttributeParam) {
        return 0;
    }
}
