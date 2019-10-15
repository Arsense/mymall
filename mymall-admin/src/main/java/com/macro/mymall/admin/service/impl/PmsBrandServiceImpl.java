package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.PmsBrand;
import com.macro.domain.model.PmsBrandExample;
import com.macro.mapper.PmsBrandMapper;
import com.macro.mymall.admin.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tangwei
 * @date 2019/10/15 16:47
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;


    @Override
    public List<PmsBrand> listAllBrand() {
        System.out.println("===========listAllBrand 调用");
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        System.out.println("===========createBrand 调用");

        return 0;
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        System.out.println("===========updateBrand 调用");

        return 0;
    }

    @Override
    public int deleteBrand(Long id) {
        System.out.println("===========deleteBrand 调用");

        return 0;
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        System.out.println("===========listBrand 调用");

        return null;
    }

    @Override
    public PmsBrand getBrand(Long id) {
        System.out.println("===========getBrand 调用");

        return null;
    }
}
