package com.macro.mapper;

import java.util.List;

import com.macro.domain.model.SmsFlashPromotionSession;
import com.macro.domain.model.SmsFlashPromotionSessionExample;
import org.apache.ibatis.annotations.Param;

public interface SmsFlashPromotionSessionMapper {
    int countByExample(SmsFlashPromotionSessionExample example);

    int deleteByExample(SmsFlashPromotionSessionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsFlashPromotionSession record);

    int insertSelective(SmsFlashPromotionSession record);

    List<SmsFlashPromotionSession> selectByExample(SmsFlashPromotionSessionExample example);

    SmsFlashPromotionSession selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsFlashPromotionSession record, @Param("example") SmsFlashPromotionSessionExample example);

    int updateByExample(@Param("record") SmsFlashPromotionSession record, @Param("example") SmsFlashPromotionSessionExample example);

    int updateByPrimaryKeySelective(SmsFlashPromotionSession record);

    int updateByPrimaryKey(SmsFlashPromotionSession record);
}