package com.macro.mymall.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.domain.model.pms.PmsProductCategory;
import com.macro.domain.model.pms.PmsProductCategoryAttributeRelation;
import com.macro.domain.model.pms.PmsProductCategoryExample;
import com.macro.domain.model.pms.PmsProductCategoryWithChildrenItem;
import com.macro.mapper.PmsProductCategoryAttributeRelationDao;
import com.macro.mapper.PmsProductCategoryDao;
import com.macro.mapper.PmsProductCategoryMapper;
import com.macro.mymall.admin.request.PmsProductCategoryParam;
import com.macro.mymall.admin.service.PmsProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clay
 * @date 2019/10/27 22:40
 */
@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {


    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;

    @Autowired
    private PmsProductCategoryAttributeRelationDao productCategoryAttributeRelationDao;

    @Autowired
    private PmsProductCategoryDao productCategoryDao;

    @Override
    public PmsProductCategory getItem(Long id) {
        return null;
    }


    @Override
    public List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductCategoryExample record = new PmsProductCategoryExample();
        record.createCriteria().andParentIdEqualTo(parentId);
        record.setOrderByClause("sort desc");
        return productCategoryMapper.selectByExample(record);
    }


    @Override
    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        PmsProductCategory pmsProductCategory = new PmsProductCategory();
        pmsProductCategory.setNavStatus(navStatus);
        PmsProductCategoryExample record = new PmsProductCategoryExample();
        record.createCriteria().andIdIn(ids);

        return productCategoryMapper.updateByExampleSelective(pmsProductCategory, record);
    }

    /**
     *
     * @param productCategoryParam
     * @return
     */
    @Override
    public int create(PmsProductCategoryParam productCategoryParam) {
        PmsProductCategory productCategory = new PmsProductCategory();
        BeanUtils.copyProperties(productCategoryParam, productCategory);
        //没有父类时为一级分类
        buildCategorytLevel(productCategory);

        int count = productCategoryMapper.insertSelective(productCategory);
        //创建属性与分类的关系
        List<Long> productAttributeList = productCategoryParam.getProductAttributeIdList();

        if(!CollectionUtils.isEmpty(productAttributeList)){
            insertRelationList(productCategory.getId(), productAttributeList);
        }
        return count;
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryDao.listWithChildren();
    }

    @Override
    public int delete(Long id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsProductCategory pmsProductCategory = new PmsProductCategory();
        pmsProductCategory.setShowStatus(showStatus);
        PmsProductCategoryExample record = new PmsProductCategoryExample();
        record.createCriteria().andIdIn(ids);

        return productCategoryMapper.updateByExampleSelective(pmsProductCategory, record);
    }


    private void insertRelationList(Long productCategoryId, List<Long> productAttributeIdList) {
        List<PmsProductCategoryAttributeRelation> relationList = new ArrayList<>();

        for (Long productAttrId : productAttributeIdList) {
            PmsProductCategoryAttributeRelation relation = new PmsProductCategoryAttributeRelation();
            relation.setProductAttributeId(productAttrId);
            relation.setProductCategoryId(productCategoryId);
            relationList.add(relation);
        }
        productCategoryAttributeRelationDao.insertList(relationList);
    }

    /**
     * 根据分类的parentId设置分类的level
     */
    private void buildCategorytLevel(PmsProductCategory productCategory) {
        //没有父类时为一级分类
        if (productCategory.getParentId() == 0) {
            productCategory.setLevel(0);

        } else {
            //有父分类时选择根据父分类level设置
            PmsProductCategory parentCategory = productCategoryMapper.selectByPrimaryKey(productCategory.getParentId());
            if (parentCategory != null) {
                productCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                productCategory.setLevel(0);
            }
        }
    }

}
