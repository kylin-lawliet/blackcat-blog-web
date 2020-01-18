package com.blackcat.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : blackcat
 * @date : 2020/1/13 22:06
 */
@Controller
@RequestMapping("user")
public class SysUserController {

    private static String ROOT = "user";

    //@RequiresPermissions("users")
    @RequestMapping("/list")
    public String list() {
        return ROOT+"/list";
    }

    //@RequiresPermissions("user:show")
    @ResponseBody
    @RequestMapping("/show")
    public String showUser() {
        return "这是学生信息";
    }
}
