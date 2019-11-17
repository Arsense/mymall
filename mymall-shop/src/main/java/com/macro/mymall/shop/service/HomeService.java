package com.macro.mymall.shop.service;

import com.macro.domain.model.ums.PmsProduct;
import com.macro.mymall.shop.domain.HomeContentResult;

import java.util.List;

/**
 * 首页内容管理Service实现类
 * @author tangwei
 * @date 2019/11/17 20:14
 */

public interface HomeService {

    /**
     * 获取首页内容
     */
    HomeContentResult content();


    /**
     * 首页商品推荐
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);



}
