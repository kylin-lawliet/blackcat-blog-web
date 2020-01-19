package com.blackcat.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.blackcat.blog.core.extend.MenuExtend;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.SysMenuService;
import com.blackcat.blog.core.vo.MenuConditionVO;
import com.blackcat.blog.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p> ：权限管理
 * @author : blackcat
 * @date : 2020/1/17 14:06
 */
@Controller
@RequestMapping("/menu")
public class SysMenuController {
    @Autowired
    private SysMenuService menuService;

    /**
     * <p> : 跳转权限管理页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
    */
    //@RequiresPermissions("resources")
    @GetMapping("/index")
    public String resources() {
        return "menu/list";
    }

    /*@RequestMapping("/list")
    @ResponseBody
    public JSONObject getAll(MenuConditionVO vo) {
        PageInfo<MenuExtend> pageInfo = menuService.findPageBreakByCondition(vo);
        System.out.println(ResultUtil.tablePage(pageInfo).toString());
        return ResultUtil.tablePage(pageInfo);
    }*/

    //@RequestMapping("/list")
    @PostMapping("/list")
    @ResponseBody
    public PageResult getAll(MenuConditionVO vo) {
        PageInfo<MenuExtend> pageInfo = menuService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }
}
