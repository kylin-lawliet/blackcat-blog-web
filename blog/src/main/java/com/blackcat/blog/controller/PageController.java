package com.blackcat.blog.controller;

import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.service.BlogCodeListService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * <p> ：页面跳转类
 * @author : blackcat
 * @date : 2020/1/20 19:11
 */
@Controller
public class PageController {

    @Resource
    private BlogCodeListService iBlogListCodeService;

    /**
     * <p> : 跳转系统配置页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @GetMapping("/system/options")
    public String options() {
        return "options/index";
    }

    /**
     * <p> : 跳转总码表管理页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @GetMapping("/article/index")
    public String article() {
        return "blog/article";
    }

    /**
     * <p> : 跳转总码表管理页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @GetMapping("/article/detail")
    public String newArticle() {
        return "blog/article_detail";
    }


    /**
     * <p> : 跳转总码表管理页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @GetMapping("/code/listIndex")
    public String codeList() {
        return "blog/code_list";
    }

    /**
     * <p> : 跳转子码表管理页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @GetMapping("/code/index/{id}")
    public String code(@PathVariable Long id, ModelMap map) {
        map.addAttribute("codeParent", iBlogListCodeService.getById(id));
        return "blog/code";
    }


    /**
     * <p> 描述 : 访问项后台管理首页
     * @author : blackcat
     * @date  : 2020/2/3 17:02
     */
    @RequiresUser
    @GetMapping("/admin")
    public String home() {
        Subject subject = SecurityUtils.getSubject();
        SysUser user=(SysUser) subject.getPrincipal();
        if (user == null){
            return "login";
        }else{
            return "admin";
        }
    }

    /**
     * <p> : 跳转前台首页
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @RequestMapping("/")
    public String web() {
        return "index";
    }

    /**
     * <p> : 跳转权限管理页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @GetMapping("/menu/index")
    public String resources() {
        return "system/menu";
    }

    /**
     * <p> : 跳转用户管理列表页面
     * @author : blackcat
     * @date : 2020/1/19 13:46
     */
    @GetMapping("/user/index")
    public String user() {
        return "system/user";
    }

    /**
     * <p> : 跳转角色管理列表页面
     * @author : blackcat
     * @date : 2020/1/19 13:46
     */
    @GetMapping("/role/index")
    public String role() {
        return "system/role";
    }

}
