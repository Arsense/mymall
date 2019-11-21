package com.macro.mymall.shop.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * 购物车管理Service
 * @author clay
 * @date 2019/11/17 21:50
 */
public interface OmsCartItemService {

//    /**
//     * 查询购物车中是否包含该商品，有增加数量，无添加到购物车
//     */
//    @Transactional
//    int createCartItem(OmsCartItem cartItem);
//
//
//    /**
//     * 根据会员编号获取购物车列表
//     */
//    List<OmsCartItem> getOmsCartItems(Long memberId);
//
//    /**
//     * 获取包含促销活动信息的购物车列表
//     */
//    List<CartPromotionItem> getPromotionsByMemberId(Long memberId);
//
//
//    /**
//     * 修改某个购物车商品的数量
//     */
//    int updateQuantity(Long id, Long memberId, Integer quantity);
//
//
//    /**
//     * 批量删除购物车中的商品
//     */
//    int removeOmsCartItems(Long memberId,List<Long> ids);
//
//
//    /**
//     *获取购物车中用于选择商品规格的商品信息
//     */
//    CartProduct getCartProduct(Long productId);
//
//    /**
//     * 修改购物车中商品的规格
//     * @param cartItem
//     * @return
//     */
//    @Transactional
//    int updateAttr(OmsCartItem cartItem);
//
//
//    /**
//     * 清空购物车
//     * @param memberId
//     * @return
//     */
//    int clearCart(Long memberId);
}
