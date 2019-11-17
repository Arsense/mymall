package com.macro.mymall.shop.service;

import com.macro.mymall.shop.domain.MemberBrandAttention;

import java.util.List;

/**
 * 会员关注Service
 * @author clay
 * @date 2019/11/17 21:48
 */
public interface MemberAttentionService {
    /**
     * 添加关注
     */
    int addAttention(MemberBrandAttention memberBrandAttention);

    /**
     * 取消关注
     */
    int deleteAttention(Long memberId, Long brandId);

    /**
     * 获取用户关注列表
     */
    List<MemberBrandAttention> listAttention(Long memberId);
}
