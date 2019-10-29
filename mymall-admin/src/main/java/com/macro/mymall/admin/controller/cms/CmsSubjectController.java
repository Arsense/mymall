package com.macro.mymall.admin.controller.cms;

import com.macro.domain.model.ums.CmsSubject;
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
 * 商品专题Controller
 * @author clay
 * @date 2019/10/25 10:38
 */
@Controller
@Api(tags = "CmsSubjectController", description = "商品专题管理")
@RequestMapping("/subject")
public class CmsSubjectController {


    @ApiOperation("获取全部商品专题")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> listAll() {
//        List<CmsSubject> subjectList = subjectService.listAll();
        return CommonResult.success(new ArrayList<>());
    }


}
