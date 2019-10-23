package com.macro.mymall.admin.controller.cms;

import com.macro.domain.model.ums.CmsPrefrenceArea;
import com.macro.mymall.admin.common.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 商品优选管理Controller  可以看成某个商品权重的存储
 * @author tangwei
 * @date 2019/10/22 20:10
 */
@Controller
@Api(tags = "CmsPrefrenceAreaController", description = "商品优选管理")
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {

    @ApiOperation("获取所有商品优选")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsPrefrenceArea>> listAll() {
//        List<CmsPrefrenceArea> prefrenceAreaList = prefrenceAreaService.listAll();
        List<CmsPrefrenceArea> prefrenceAreaList = new ArrayList<>();
        CmsPrefrenceArea area = new CmsPrefrenceArea();
      
        prefrenceAreaList.add(area);

        return CommonResult.success(prefrenceAreaList);
    }

}
