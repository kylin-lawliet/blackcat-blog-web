package com.blackcat.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.blackcat.blog.core.extend.UserExtend;
import com.blackcat.blog.core.service.SysUserService;
import com.blackcat.blog.core.vo.UserConditionVO;
import com.blackcat.blog.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : blackcat
 * @date : 2020/1/13 22:06
 */
@Controller
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    /**
     * <p> : 跳转用户管理列表页面
     * @author : blackcat
     * @date : 2020/1/19 13:46
    */
    //@RequiresPermissions("users")
    @GetMapping("/index")
    public String user() {
        return "user/list";
    }

    //@RequiresPermissions("users")
    /*@PostMapping("/list")
    public JSONObject list(UserConditionVO vo) {
        PageInfo<UserExtend> pageInfo = userService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }*/
}
