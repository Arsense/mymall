package com.macro.mymall.admin.service;

import com.macro.domain.model.pms.PmsProductCategory;
import com.macro.domain.model.pms.PmsProductCategoryWithChildrenItem;
import com.macro.mymall.admin.request.PmsProductCategoryParam;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/27 22:40
 */
public interface PmsProductCategoryService {


    /**
     * 分页查询商品分类
     * @param parentId
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);


    PmsProductCategory getItem(Long id);

    /**
     * 批量更新导航栏状态
     * @param ids
     * @param navStatus
     * @return
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    int create(PmsProductCategoryParam productCategoryParam);

    List<PmsProductCategoryWithChildrenItem> listWithChildren();


    int delete(Long id);

    int updateShowStatus(List<Long> ids, Integer showStatus);
}
