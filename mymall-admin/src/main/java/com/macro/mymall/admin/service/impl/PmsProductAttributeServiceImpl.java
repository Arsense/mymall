package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.pms.PmsProductAttribute;
import com.macro.domain.model.pms.PmsProductAttributeCategory;
import com.macro.domain.model.pms.PmsProductAttributeExample;
import com.macro.mapper.PmsProductAttributeCategoryMapper;
import com.macro.mapper.PmsProductAttributeMapper;
import com.macro.mymall.admin.request.PmsProductAttributeParam;
import com.macro.mymall.admin.service.PmsProductAttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tangwei
 * @date 2019/10/23 14:26
 */
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {

    public static final Logger log = LoggerFactory.getLogger(PmsProductAttributeServiceImpl.class);

    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;

    @Autowired
    private PmsProductAttributeCategoryMapper categoryMapper;

    @Override
    public List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum) {
        //构建分页参数 查询
        return null;
    }


    /**
     * 是否需要事务回滚
     *
     * @param productAttributeParam
     * @return
     */
    @Override
    public int create(PmsProductAttributeParam productAttributeParam) {
        PmsProductAttribute record = new PmsProductAttribute();
        BeanUtils.copyProperties(productAttributeParam, record);

        //新增商品属性以后需要更新商品属性分类数量
        int count = productAttributeMapper.insertSelective(record);

        PmsProductAttributeCategory category = categoryMapper.selectByPrimaryKey(record.getProductAttributeCategoryId());

        if (category == null) {
            log.info("method: create=>没有查询到相应的商品分类属性");
            return 0;
        }
        //0->规格；1->参数
        if (record.getType() == 0) {
            category.setAttributeCount( category.getAttributeCount() + 1);
        } else if(record.getType() == 1) {
            category.setParamCount( category.getParamCount() + 1);
        }

        categoryMapper.updateByPrimaryKey(category);

        return count;
    }

    @Override
    public int delete(List<Long> ids) {
        //获取分类
        PmsProductAttribute pmsProductAttribute = productAttributeMapper.selectByPrimaryKey(ids.get(0));
        Integer type = pmsProductAttribute.getType();
        PmsProductAttributeCategory pmsProductAttributeCategory = categoryMapper.selectByPrimaryKey(pmsProductAttribute.getProductAttributeCategoryId());
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.createCriteria().andIdIn(ids);
        int count = productAttributeMapper.deleteByExample(example);
        //删除完成后修改数量
        if (type == 0) {
            if (pmsProductAttributeCategory.getAttributeCount() >= count) {
                pmsProductAttributeCategory.setAttributeCount(pmsProductAttributeCategory.getAttributeCount() - count);
            } else {
                pmsProductAttributeCategory.setAttributeCount(0);
            }
        } else if (type == 1) {
            if (pmsProductAttributeCategory.getParamCount() >= count) {
                pmsProductAttributeCategory.setParamCount(pmsProductAttributeCategory.getParamCount() - count);
            } else {
                pmsProductAttributeCategory.setParamCount(0);
            }
        }
        categoryMapper.updateByPrimaryKey(pmsProductAttributeCategory);
        return count;
    }

    @Override
    public PmsProductAttribute getItem(Long id) {
        //直接查询
        if (id == null || id < 0) {
            // log something
            return null;
        }

        return productAttributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Long id, PmsProductAttributeParam productAttributeParam) {
        PmsProductAttribute pmsProductAttribute = new PmsProductAttribute();
        pmsProductAttribute.setId(id);
        BeanUtils.copyProperties(productAttributeParam, pmsProductAttribute);
        return productAttributeMapper.updateByPrimaryKeySelective(pmsProductAttribute);
    }


}
