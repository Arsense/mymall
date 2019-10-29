package com.macro.mapper;

import com.macro.domain.model.pms.ProductAttrInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/27 23:51
 */
public interface PmsProductAttributeDao {

    List<ProductAttrInfo> getProductAttrInfo(@Param("id") Long productCategoryId);


}
