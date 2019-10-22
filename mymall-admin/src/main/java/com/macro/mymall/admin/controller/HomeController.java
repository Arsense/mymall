package com.macro.mymall.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author clay
 * @date 2019/10/15 18:24
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/")
    public String index()  {
        return "forward:index.html";
    }

    @RequestMapping("/swagger-ui")
    public String swigger()  {
        return "forward:swagger-ui.html";
    }

}
