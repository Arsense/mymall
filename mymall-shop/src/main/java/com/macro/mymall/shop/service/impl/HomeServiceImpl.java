package com.macro.mymall.shop.service.impl;

import com.macro.domain.model.pms.PmsProductCategory;
import com.macro.domain.model.sms.SmsHomeAdvertise;
import com.macro.domain.model.sms.SmsHomeAdvertiseExample;
import com.macro.domain.model.ums.CmsSubject;
import com.macro.domain.model.ums.PmsProduct;
import com.macro.mapper.SmsHomeAdvertiseMapper;
import com.macro.mymall.shop.dao.HomeDao;
import com.macro.mymall.shop.domain.HomeContentResult;
import com.macro.mymall.shop.domain.HomeFlashPromotion;
import com.macro.mymall.shop.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 * 首页内容管理Service实现类
 * @date 2019/11/17 20:15
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeDao homeDao;
    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;


    @Override
    public HomeContentResult content() {

        HomeContentResult result = new HomeContentResult();

        //获取首页广告
        result.setAdvertiseList(getHomeAdvertiseList());
        //获取推荐品牌
        result.setBrandList(homeDao.getRecommendBrandList(0,4));
        //获取秒杀信息
        result.setHomeFlashPromotion(getHomeFlashPromotion());
//        //获取新品推荐
//        result.setNewProductList(homeDao.getNewProductList(0,4));
//        //获取人气推荐
//        result.setHotProductList(homeDao.getHotProductList(0,4));
//        //获取推荐专题
//        result.setSubjectList(homeDao.getRecommendSubjectList(0,4));
        return result;

    }

    @Override
    public List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public List<PmsProductCategory> getProductCateList(Long parentId) {
        return null;
    }

    @Override
    public List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum) {
        return null;
    }

    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        example.createCriteria().andTypeEqualTo(1).andStatusEqualTo(1);
        example.setOrderByClause("sort desc");
        return advertiseMapper.selectByExample(example);
    }

    public HomeFlashPromotion getHomeFlashPromotion() {

        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        //获取当前秒杀活动
        Date now = new Date();



        return homeFlashPromotion;
    }
}
