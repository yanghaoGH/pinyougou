package com.itheima.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;
    @RequestMapping("/showName.do")
    @ResponseBody
    public String getName() {
        return userService.getName();
    }
}
