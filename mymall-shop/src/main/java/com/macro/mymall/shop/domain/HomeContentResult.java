package com.macro.mymall.shop.domain;

import com.macro.domain.model.pms.PmsBrand;
import com.macro.domain.model.sms.SmsHomeAdvertise;
import com.macro.domain.model.ums.CmsSubject;
import com.macro.domain.model.ums.PmsProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author tangwei
 * @date 2019/11/17 21:31
 */
@Getter
@Setter
public class HomeContentResult {
    //轮播广告
    private List<SmsHomeAdvertise> advertiseList;
    //推荐品牌
    private List<PmsBrand> brandList;
    //当前秒杀场次
    private HomeFlashPromotion homeFlashPromotion;
    //新品推荐
    private List<PmsProduct> newProductList;
    //人气推荐
    private List<PmsProduct> hotProductList;
    //推荐专题
    private List<CmsSubject> subjectList;

}
