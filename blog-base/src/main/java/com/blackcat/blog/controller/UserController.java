package com.blackcat.blog.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: blackcat
 * @date: 2020/1/13 22:06
 */
@RequestMapping("/user")
//@Controller
@RestController
public class UserController {

    @RequiresPermissions("user:show")
    @ResponseBody
    @RequestMapping("/show")
    public String showUser() {
        return "这是学生信息";
    }
}
