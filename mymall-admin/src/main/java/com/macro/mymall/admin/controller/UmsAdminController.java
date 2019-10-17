package com.macro.mymall.admin.controller;

import com.macro.domain.model.UmsAdminLoginParam;
import com.macro.mymall.admin.common.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tangwei
 * @date 2019/10/16 18:15
 */
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
@Controller
public class UmsAdminController {


    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam loginParam, BindingResult result) {


        return null;
    }



}
