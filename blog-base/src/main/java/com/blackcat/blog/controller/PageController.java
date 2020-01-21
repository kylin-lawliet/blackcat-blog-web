package com.blackcat.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p> ：页面跳转类
 * @author : blackcat
 * @date : 2020/1/20 19:11
 */
@Controller
public class PageController {

    /**
     * <p> : 后台主页
     * @author : blackcat
     * @date : 2020/1/20 19:19
    */
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * <p> : 跳转权限管理页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    //@RequiresPermissions("resources")
    @GetMapping("/menu/index")
    public String resources() {
        return "menu/list";
    }

    /**
     * <p> : 跳转用户管理列表页面
     * @author : blackcat
     * @date : 2020/1/19 13:46
     */
    //@RequiresPermissions("users")
    @GetMapping("/user/index")
    public String user() {
        return "user/list";
    }
}
