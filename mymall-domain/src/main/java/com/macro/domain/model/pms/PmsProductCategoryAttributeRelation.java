package com.macro.domain.model.pms;

import lombok.Data;

/**
 * @author tangwei
 * @date 2019/10/29 11:02
 */
@Data
public class PmsProductCategoryAttributeRelation {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 商品类别
     */
    private Long productCategoryId;


    /**
     * 商品属性
     */
    private Long productAttributeId;

}
