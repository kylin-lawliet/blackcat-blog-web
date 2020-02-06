package com.blackcat.blog.controller;

import com.blackcat.blog.core.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
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
     * <p> 描述 : 访问项目根路径
     * @author : blackcat
     * @date  : 2020/2/3 17:02
     */
    @RequiresUser
    @GetMapping(value = {"", "/index"})
    public String home() {
        Subject subject = SecurityUtils.getSubject();
        SysUser user=(SysUser) subject.getPrincipal();
        if (user == null){
            return "login";
        }else{
            return "index";
        }
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

    /**
     * <p> : 跳转角色管理列表页面
     * @author : blackcat
     * @date : 2020/1/19 13:46
     */
    @GetMapping("/role/index")
    public String role() {
        return "role/list";
    }
}
