package com.macro.mymall.shop.service.impl;

import com.macro.mymall.shop.domain.MemberBrandAttention;
import com.macro.mymall.shop.repository.MemberBrandAttentionRepository;
import com.macro.mymall.shop.service.MemberAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/17 21:48
 */
@Service
public class MemberAttentionServiceImpl implements MemberAttentionService{

//    @Autowired
//    private MemberBrandAttentionRepository memberBrandAttentionRepository;

    @Override
    public int createAttention(MemberBrandAttention memberBrandAttention) {
//        int count = 0;
//        MemberBrandAttention findAttention = memberBrandAttentionRepository.findByMemberIdAndBrandId(memberBrandAttention.getMemberId(), memberBrandAttention.getBrandId());
//        if (findAttention == null) {
//            memberBrandAttentionRepository.save(memberBrandAttention);
//            count = 1;
//        }
//        return count;
        return 1;
    }

    @Override
    public int deleteAttention(Long memberId, Long brandId) {
        return 1;
//        return memberBrandAttentionRepository.deleteByMemberIdAndBrandId(memberId,brandId);
    }

    @Override
    public List<MemberBrandAttention> listAttention(Long memberId) {
        return null;
//        return memberBrandAttentionRepository.findByMemberId(memberId);
    }
}
