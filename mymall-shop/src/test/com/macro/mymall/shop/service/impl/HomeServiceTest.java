package com.macro.mymall.shop.service.impl;

import com.macro.mymall.shop.BaseTest;
import com.macro.mymall.shop.domain.HomeContentResult;
import com.macro.mymall.shop.service.HomeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author clay
 * @date 2019/11/18 1:28
 */
public class HomeServiceTest extends BaseTest {


    @Autowired
    private HomeService homeService;
    @Test
    public void content() {
        HomeContentResult result = homeService.content();

        System.out.println("content结果是");
    }

    @Test
    public void recommendProductList() {
    }

    @Test
    public void getProductCateList() {
    }

    @Test
    public void getSubjectList() {
    }
}