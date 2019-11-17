package com.macro.mymall.shop.domain;

import java.util.Date;
import java.util.List;

/**
 *
 * 首页当前秒杀场次信息
 * @date 2019/11/17 21:32
 */
public class HomeFlashPromotion {
    private Date startTime;
    private Date endTime;
    private Date nextStartTime;
    private Date nextEndTime;

    /**
     * 属于该秒杀活动的商品
     */
    private List<FlashPromotionProduct> productList;
}
