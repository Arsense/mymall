package com.macro.mymall.admin.service.impl.oms;

import com.macro.domain.model.oms.OmsOrderSetting;
import com.macro.mapper.OmsOrderSettingMapper;
import com.macro.mymall.admin.service.OmsOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author clay
 * @date 2019/10/29 19:36
 */
@Service
public class OmsOrderSettingServiceImpl implements OmsOrderSettingService {

    @Autowired
    private OmsOrderSettingMapper omsOrderSettingMapper;


    @Override
    public OmsOrderSetting getItem(Long id) {

        return omsOrderSettingMapper.selectByPrimaryKey(id);
    }
}
