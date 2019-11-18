package com.macro.mymall.shop.service.impl;

import com.macro.domain.model.SmsFlashPromotionSession;
import com.macro.domain.model.SmsFlashPromotionSessionExample;
import com.macro.domain.model.pms.PmsProductCategory;
import com.macro.domain.model.sms.*;
import com.macro.domain.model.ums.CmsSubject;
import com.macro.domain.model.ums.PmsProduct;
import com.macro.mapper.SmsFlashPromotionMapper;
import com.macro.mapper.SmsFlashPromotionSessionMapper;
import com.macro.mapper.SmsHomeAdvertiseMapper;
import com.macro.mymall.shop.dao.HomeDao;
import com.macro.mymall.shop.domain.FlashPromotionProduct;
import com.macro.mymall.shop.domain.HomeContentResult;
import com.macro.mymall.shop.domain.HomeFlashPromotion;
import com.macro.mymall.shop.service.HomeService;
import com.macro.mymall.shop.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *
 * 首页内容管理Service实现类
 * @date 2019/11/17 20:15
 */
@Service
public class HomeServiceImpl implements HomeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeServiceImpl.class);

    @Autowired
    private HomeDao homeDao;

    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;

    @Autowired
    private SmsFlashPromotionMapper flashPromotionMapper;

    @Autowired
    private SmsFlashPromotionSessionMapper promotionSessionMapper;

    @Override
    public HomeContentResult content() {

        HomeContentResult result = new HomeContentResult();

        //获取首页广告
        try {
            result.setAdvertiseList(getHomeAdvertiseList());
            //获取推荐品牌
            result.setBrandList(homeDao.getRecommendBrandList(0,4));
            //获取秒杀信息
            result.setHomeFlashPromotion(getHomeFlashPromotion());
            //获取新品推荐
            result.setNewProductList(homeDao.getNewProductList(0,4));
            //获取人气推荐
            result.setHotProductList(homeDao.getHotProductList(0,4));
            //获取推荐专题
            result.setSubjectList(homeDao.getRecommendSubjectList(0,4));
        } catch (Exception e) {
            LOGGER.info("method:content, 调用异常", e);
        }
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
        SmsFlashPromotion flashPromotion = getFlashPromotion(now);
        if (flashPromotion != null) {
            //获取当前秒杀场次
            SmsFlashPromotionSession flashPromotionSession = getFlashPromotionSession(now);
            if (flashPromotionSession != null) {
                homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
                homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
                //获取下一个秒杀场次
                SmsFlashPromotionSession nextSession = getNextFlashPromotionSession(homeFlashPromotion.getStartTime());
                if(nextSession!=null){
                    homeFlashPromotion.setNextStartTime(nextSession.getStartTime());
                    homeFlashPromotion.setNextEndTime(nextSession.getEndTime());
                }
                //获取秒杀商品
                List<FlashPromotionProduct> flashProductList = homeDao.getFlashProductList(flashPromotion.getId(), flashPromotionSession.getId());
                homeFlashPromotion.setProductList(flashProductList);
            }
        }
        return homeFlashPromotion;

    }

    /**
     * 获取下一个秒杀场次
     * @param startTime
     * @return
     */
    private SmsFlashPromotionSession getNextFlashPromotionSession(Date startTime) {
        SmsFlashPromotionSessionExample sessionExample = new SmsFlashPromotionSessionExample();
        sessionExample.createCriteria()
                .andStartTimeGreaterThan(startTime);
        sessionExample.setOrderByClause("start_time asc");
        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }

    /**
     * 根据时间获取秒杀场次
     * @param date
     * @return
     */
    private SmsFlashPromotionSession getFlashPromotionSession(Date date) {
        Date currTime = DateUtil.getTime(date);
        SmsFlashPromotionSessionExample sessionExample = new SmsFlashPromotionSessionExample();
        sessionExample.createCriteria()
                .andStartTimeLessThanOrEqualTo(currTime)
                .andEndTimeGreaterThanOrEqualTo(currTime);
        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }

    /**
     * 获取秒杀信息
     * @param now
     * @return
     */
    private SmsFlashPromotion getFlashPromotion(Date now) {
        Date currDate = DateUtil.getDate(now);
        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
        example.createCriteria()
                .andStatusEqualTo(1)
                .andStartDateLessThanOrEqualTo(currDate)
                .andEndDateGreaterThanOrEqualTo(currDate);
        List<SmsFlashPromotion> flashPromotionList = flashPromotionMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(flashPromotionList)) {
            return flashPromotionList.get(0);
        }
        return null;
    }


}
