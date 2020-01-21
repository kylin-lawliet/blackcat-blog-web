package com.blackcat.blog.controller;

import com.blackcat.blog.common.base.*;
import com.blackcat.blog.core.extend.UserExtend;
import com.blackcat.blog.core.service.SysUserService;
import com.blackcat.blog.core.vo.UserConditionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理Controller
 * @author : blackcat
 * @date : 2020/1/13 22:06
 */
@RestController
@RequestMapping("user")
public class SysUserController extends AbstractController<UserExtend,UserConditionVO> {

    @Autowired
    private SysUserService userService;

    @Override
    protected String getName() {
        return "用户";
    }

    @Override
    protected AbstractService<UserExtend,UserConditionVO> getService() {
        return userService;
    }
}
