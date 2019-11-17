package com.macro.mymall.shop.service.impl;

import com.macro.domain.model.ums.PmsProduct;
import com.macro.mymall.shop.domain.HomeContentResult;
import com.macro.mymall.shop.service.HomeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 首页内容管理Service实现类
 * @date 2019/11/17 20:15
 */
@Service
public class HomeServiceImpl implements HomeService {


    @Override
    public HomeContentResult content() {
        return null;
    }

    @Override
    public List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        return null;
    }
}
