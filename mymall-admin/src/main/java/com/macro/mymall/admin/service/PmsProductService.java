package com.macro.mymall.admin.service;

import com.macro.domain.model.ums.PmsProduct;
import com.macro.mymall.admin.query.PmsProductQueryParam;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/21 21:07
 */
public interface PmsProductService {

    /**
     * 分页查询商品
     */
    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);
}
