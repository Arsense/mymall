package com.macro.mapper;

import com.macro.domain.model.pms.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * @author tangwei
 * @date 2019/10/29 11:33
 */
public interface PmsProductCategoryDao {

    List<PmsProductCategoryWithChildrenItem> listWithChildren();

}
