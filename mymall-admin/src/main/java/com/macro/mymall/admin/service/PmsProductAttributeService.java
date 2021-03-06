package com.macro.mymall.admin.service;

import com.macro.domain.model.pms.PmsProductAttribute;
import com.macro.domain.model.pms.ProductAttrInfo;
import com.macro.mymall.admin.request.PmsProductAttributeParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List; /**
 * @author clay
 * @date 2019/10/23 14:26
 */
public interface PmsProductAttributeService {

    /**
     * 根据分类分页获取商品属性
     * @param cid 分类id
     * @param type 0->属性；2->参数
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 获取单个商品属性信息
     * @param id
     * @return
     */
    PmsProductAttribute getItem(Long id);

    /**
     *
     * @param id
     * @param productAttributeParam
     * @return
     */
    int update(Long id, PmsProductAttributeParam productAttributeParam);

    /**
     *
     * @param productAttributeParam
     * @return
     */
    @Transactional
    int create(PmsProductAttributeParam productAttributeParam);


    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}
