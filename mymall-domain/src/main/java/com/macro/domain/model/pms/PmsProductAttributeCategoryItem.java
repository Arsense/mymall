package com.macro.domain.model.pms;

import java.util.List;

/**
 * @author tangwei
 * @date 2019/10/28 0:50
 */
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {


    private List<PmsProductAttribute> productAttributeList;

    public List<PmsProductAttribute> getProductAttributeList() {
        return productAttributeList;
    }

    public void setProductAttributeList(List<PmsProductAttribute> productAttributeList) {
        this.productAttributeList = productAttributeList;
    }
}
