package com.macro.mymall.shop.controller;

import com.macro.mymall.shop.service.HomeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tangwei
 * @date 2019/11/17 19:42
 */
@Controller
@Api(tags = "HomeController", description = "首页内容管理")
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

}
