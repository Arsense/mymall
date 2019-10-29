package com.macro.domain.model.pms;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/22 18:34
 */
public class PmsProductCategoryWithChildrenItem  extends PmsProductCategory {

    private List<PmsProductCategory> children;

    public List<PmsProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<PmsProductCategory> children) {
        this.children = children;
    }
}
