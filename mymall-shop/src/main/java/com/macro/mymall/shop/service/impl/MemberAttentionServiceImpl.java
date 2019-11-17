package com.macro.mymall.shop.service.impl;

import com.macro.mymall.shop.domain.MemberBrandAttention;
import com.macro.mymall.shop.service.MemberAttentionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/17 21:48
 */
@Service
public class MemberAttentionServiceImpl implements MemberAttentionService{
    @Override
    public int addAttention(MemberBrandAttention memberBrandAttention) {
        return 0;
    }

    @Override
    public int deleteAttention(Long memberId, Long brandId) {
        return 0;
    }

    @Override
    public List<MemberBrandAttention> listAttention(Long memberId) {
        return null;
    }
}
