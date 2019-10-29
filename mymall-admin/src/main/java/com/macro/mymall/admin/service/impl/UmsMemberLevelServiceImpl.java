package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.ums.UmsMemberLevel;
import com.macro.domain.model.ums.UmsMemberLevelExample;
import com.macro.mapper.UmsMemberLevelMapper;
import com.macro.mymall.admin.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/25 10:30
 */
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService{

    @Autowired
    private UmsMemberLevelMapper umsMemberLevelMapper;

    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample record = new UmsMemberLevelExample();
        record.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return umsMemberLevelMapper.selectByExample(record);
    }
}
