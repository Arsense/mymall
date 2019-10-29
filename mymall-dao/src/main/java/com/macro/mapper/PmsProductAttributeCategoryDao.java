package com.macro.mapper;

import com.macro.domain.model.pms.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/28 0:53
 */
public interface PmsProductAttributeCategoryDao {
    List<PmsProductAttributeCategoryItem> getListWithAttr();


}
