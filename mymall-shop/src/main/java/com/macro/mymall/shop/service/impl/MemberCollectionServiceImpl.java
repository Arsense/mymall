package com.macro.mymall.shop.service.impl;

import com.macro.mymall.shop.domain.MemberProductCollection;
import com.macro.mymall.shop.service.MemberCollectionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author clay
 * @date 2019/11/17 21:49
 */
@Service
public class MemberCollectionServiceImpl implements MemberCollectionService{
    @Override
    public int addProduct(MemberProductCollection productCollection) {
        return 0;
    }

    @Override
    public int deleteProduct(Long memberId, Long productId) {
        return 0;
    }

    @Override
    public List<MemberProductCollection> listProduct(Long memberId) {
        return null;
    }
}
