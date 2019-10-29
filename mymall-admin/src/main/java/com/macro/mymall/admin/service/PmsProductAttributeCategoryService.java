package com.macro.mymall.admin.service;

import com.macro.domain.model.pms.PmsProductAttributeCategory;
import com.macro.domain.model.pms.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/25 11:29
 */
public interface PmsProductAttributeCategoryService {

    /**
     * 分页获取展示
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    /**
     * 创建商品服务
     * @param name
     * @return
     */
    int create(String name);

    /**
     * 更新商品服务
     * @param id
     * @param name
     * @return
     */
    int update(Long id, String name);


    /**
     * 根据id删除服务
     * @param id
     * @return
     */
    int delete(Long id);


    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
