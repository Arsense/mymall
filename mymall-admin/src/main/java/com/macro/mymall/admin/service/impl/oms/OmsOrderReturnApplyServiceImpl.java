package com.macro.mymall.admin.service.impl.oms;

import com.github.pagehelper.PageHelper;
import com.macro.domain.model.oms.OmsOrderReturnApply;
import com.macro.domain.model.oms.OmsOrderReturnApplyExample;
import com.macro.mapper.OmsOrderReturnApplyMapper;
import com.macro.mymall.admin.request.OmsReturnApplyQueryParam;
import com.macro.mymall.admin.service.OmsOrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/29 19:51
 */
@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {



    @Autowired
    private OmsOrderReturnApplyMapper returnApplyMapper;

    @Override
    public List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum) {

        PageHelper.startPage(pageNum, pageSize);
        //todo 这里需要优化
        OmsOrderReturnApplyExample example = new OmsOrderReturnApplyExample();
        if( queryParam.getId() != null) {
            example.createCriteria().andIdEqualTo(queryParam.getId());
        }
        if( queryParam.getHandleMan() != null) {
            example.createCriteria().andHandleManEqualTo(queryParam.getHandleMan());
        }

        if( queryParam.getStatus() != null) {
            example.createCriteria().andStatusEqualTo(queryParam.getStatus());
        }

        return returnApplyMapper.selectByExample(example);
    }
}
