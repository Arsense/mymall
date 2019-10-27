package com.macro.mymall.admin.service;

import com.macro.domain.model.pms.PmsProductCategory;
import org.springframework.stereotype.Service;

/**
 * @author tangwei
 * @date 2019/10/27 22:40
 */
public interface PmsProductCategoryService {


    PmsProductCategory getItem(Long id);
}
