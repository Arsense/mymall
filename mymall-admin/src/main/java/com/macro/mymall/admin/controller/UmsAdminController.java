package com.macro.mymall.admin.controller;

import com.macro.domain.model.UmsAdminLoginParam;
import com.macro.mymall.admin.common.CommonResult;
import com.macro.mymall.admin.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.*;
/**
 * @author tangwei
 * @date 2019/10/16 18:15
 */
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
@Controller
public class UmsAdminController {
    @Autowired
    private UmsAdminService adminService;
    /**
     * 相当于jwt secret
     */
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam loginParam, BindingResult result) {
        String token = adminService.login(loginParam.getUsername(), loginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);


    }



}
