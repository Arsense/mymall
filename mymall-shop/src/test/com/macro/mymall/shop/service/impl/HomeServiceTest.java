package com.macro.mymall.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.macro.domain.model.cms.CmsSubject;
import com.macro.domain.model.pms.PmsProductCategory;
import com.macro.domain.model.ums.PmsProduct;
import com.macro.mymall.shop.BaseTest;
import com.macro.mymall.shop.domain.HomeContentResult;
import com.macro.mymall.shop.service.HomeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/18 1:28
 */
public class HomeServiceTest extends BaseTest {

    @Autowired
    private HomeService homeService;


    @Test
    public void content() {
        HomeContentResult result = null;
        try {
            result = homeService.content();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.notNull(result, "首页信息不能为空");

        System.out.println("结果是=================="+ JSON.toJSON(result));
    }

    @Test
    public void recommendProductList() {
        Integer pageSize = 5;
        Integer pageNum = 0;

        List<PmsProduct> pmsProducts  = homeService.recommendProductList(pageSize, pageNum);

        Assert.isTrue(pmsProducts.size() > 0, "推荐商品不能为空");

        System.out.println("推荐商品结果是=================="+ JSON.toJSON(pmsProducts));
    }

    @Test
    public void getProductCateList() {
        Long parentId = 0L;
        List<PmsProductCategory> productCateList = homeService.getProductCateList(parentId);

        Assert.isTrue(productCateList.size() > 0, "推荐商品不能为空");

        System.out.println("获取类目列表==================" + JSON.toJSON(productCateList));
    }

    @Test
    public void getSubjectList() {
        Long cateId = 123L;
        Integer pageSize = 5;
        Integer pageNum = 0;
        List<CmsSubject> subjects = homeService.getSubjectList(cateId, pageSize, pageNum);

        Assert.isTrue(subjects.size() > 0, "推荐商品不能为空");

        System.out.println("getSubjectList==================" + JSON.toJSON(subjects));

    }







}