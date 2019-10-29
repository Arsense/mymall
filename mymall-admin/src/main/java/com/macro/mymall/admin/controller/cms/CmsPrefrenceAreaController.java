package com.macro.mymall.admin.controller.cms;

import com.macro.domain.model.cms.CmsPrefrenceArea;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.service.CmsPrefrenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * 商品优选管理Controller  可以看成某个商品权重的存储
 * @author clay
 * @date 2019/10/22 20:10
 */
@Controller
@Api(tags = "CmsPrefrenceAreaController", description = "商品优选管理")
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {

    @Autowired
    CmsPrefrenceAreaService prefrenceAreaService;



    @ApiOperation("获取所有商品优选")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsPrefrenceArea>> listAll() {
        List<CmsPrefrenceArea> prefrenceAreaList = prefrenceAreaService.listAll();
        CmsPrefrenceArea area = new CmsPrefrenceArea();
        area.setId(1L);
        area.setName("测试优选");
        area.setShowStatus(1);
        area.setSort(10);
        area.setSubTitle("subline");
        prefrenceAreaList.add(area);

        return CommonResult.success(prefrenceAreaList);
    }

}
