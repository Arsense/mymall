package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.pms.PmsProductAttributeCategory;
import com.macro.domain.model.pms.PmsProductAttributeCategoryItem;
import com.macro.mapper.PmsProductAttributeCategoryDao;
import com.macro.mapper.PmsProductAttributeCategoryMapper;
import com.macro.mymall.admin.service.PmsProductAttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tangwei
 * @date 2019/10/25 11:30
 */
@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {

    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;

    @Autowired
    private PmsProductAttributeCategoryDao productAttributeCategoryDao;

    @Override
    public List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public int create(String name) {
        PmsProductAttributeCategory record = new PmsProductAttributeCategory();
        record.setName(name);
        return productAttributeCategoryMapper.insert(record);
    }

    @Override
    public int update(Long id, String name) {
        PmsProductAttributeCategory record = new PmsProductAttributeCategory();
        record.setId(id);
        record.setName(name);

        return  productAttributeCategoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(Long id) {
        return productAttributeCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsProductAttributeCategoryItem> getListWithAttr() {
        return productAttributeCategoryDao.getListWithAttr();

    }
}
