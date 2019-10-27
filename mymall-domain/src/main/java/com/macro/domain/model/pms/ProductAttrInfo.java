package com.macro.domain.model.pms;

/**
 *
 * 商品分类对应属性信息
 * @author tangwei
 * @date 2019/10/27 23:44
 */
public class ProductAttrInfo {

    private Long attributeId;
    private Long attributeCategoryId;

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public Long getAttributeCategoryId() {
        return attributeCategoryId;
    }

    public void setAttributeCategoryId(Long attributeCategoryId) {
        this.attributeCategoryId = attributeCategoryId;
    }
}
