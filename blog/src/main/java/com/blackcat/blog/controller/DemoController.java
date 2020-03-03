package com.blackcat.blog.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p> ：示例
 * @author : blackcat
 * @date : 2020/1/20 19:11
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    /**
     * <p> : 跳转bootstrap 基础样式 示例页面
     * @author : blackcat
     * @date : 2020/1/19 13:46
     */
    @RequiresPermissions("demo:bootstrap")
    @RequestMapping("/bootstrap")
    public String bootstrap() {
        return "demo/bootstrap";
    }

    /**
     * <p> : 跳转bootstrap 树形表格 示例页面
     * @author : blackcat
     * @date : 2020/2/19 13:46
     */
    @RequiresPermissions("demo:table_tree")
    @RequestMapping("/tableTree")
    public String tableTree() {
        return "demo/table-tree";
    }

    /**
     * <p> 描述 : tagsinput标系统
     * @author : blackcat
     * @date  : 2020/3/1 14:06   
    */
    @RequiresPermissions("demo:tagsinput")
    @RequestMapping("/tagsinput")
    public String tagsinput() {
        return "demo/tagsinput";
    }
    
}
