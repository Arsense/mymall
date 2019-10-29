package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.cms.CmsPrefrenceArea;
import com.macro.domain.model.cms.CmsPrefrenceAreaExample;
import com.macro.mapper.CmsPrefrenceAreaMapper;
import com.macro.mymall.admin.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/25 9:54
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {

    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
