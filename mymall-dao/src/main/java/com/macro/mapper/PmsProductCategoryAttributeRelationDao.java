package com.macro.mapper;

import com.macro.domain.model.pms.PmsProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List; /**
 * @author clay
 * @date 2019/10/29 11:03
 */
public interface PmsProductCategoryAttributeRelationDao {
    int insertList(@Param("list") List<PmsProductCategoryAttributeRelation> relationList);
}
