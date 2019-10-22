package com.macro.mymall.admin.service;

import com.macro.domain.model.PmsBrand;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/15 16:46
 */
public interface PmsBrandService {

    /**
     * 展示所有商标
     * @return
     */
    List<PmsBrand> listAllBrand();

    /**
     * 创建商标
     * @param brand
     * @return
     */
    int createBrand(PmsBrand brand);

    /**
     * 更新商标
     * @param id
     * @param brand
     * @return
     */
    int updateBrand(Long id, PmsBrand brand);

    /**
     * 删除brand
     * @param id
     * @return
     */
    int deleteBrand(Long id);


    /**
     * 分页查询商标
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);


    /**
     * 根据id 查询brand
     * @param id
     * @return
     */
    PmsBrand getBrand(Long id);


}
