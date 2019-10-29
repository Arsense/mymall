package com.macro.mymall.admin.service;

import com.macro.domain.model.ums.UmsMemberLevel;

import java.util.List;

/**
 * @author clay
 * @date 2019/10/25 10:30
 */
public interface UmsMemberLevelService {

    /**
     * 获取会员等级
     * @param defaultStatus
     * @return
     */
    List<UmsMemberLevel> list(Integer defaultStatus);
}
