package com.macro.mymall.admin.service;

import com.macro.domain.model.pms.PmsProductAttributeCategory;

import java.util.List;

/**
 * @author tangwei
 * @date 2019/10/25 11:29
 */
public interface PmsProductAttributeCategoryService {
    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);
}
