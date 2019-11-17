package com.macro.mymall.shop.service;

import com.macro.mymall.shop.domain.MemberProductCollection;

import java.util.List;

/**
 * 会员收藏Service
 * @author clay
 * @date 2019/11/17 21:48
 */
public interface MemberCollectionService {
    int addProduct(MemberProductCollection productCollection);

    int deleteProduct(Long memberId, Long productId);

    List<MemberProductCollection> listProduct(Long memberId);
}
