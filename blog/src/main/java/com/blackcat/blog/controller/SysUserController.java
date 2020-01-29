package com.blackcat.blog.controller;

import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.extend.UserExtend;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.SysUserRoleService;
import com.blackcat.blog.core.service.SysUserService;
import com.blackcat.blog.core.vo.ResponseVO;
import com.blackcat.blog.core.vo.UserConditionVO;
import com.blackcat.blog.util.PasswordUtil;
import com.blackcat.blog.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理Controller
 * @author : blackcat
 * @date : 2020/1/13 22:06
 */
@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysUserRoleService userRoleService;

    //@RequiresPermissions("users")
    @PostMapping("/list")
    public PageResult list(UserConditionVO vo) {
        PageInfo<UserExtend> pageInfo = userService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * 保存用户角色
     *
     * @param userId
     * @param roleIds
     *         用户角色
     *         此处获取的参数的角色id是以 “,” 分隔的字符串
     * @return
     */
    //@RequiresPermissions("user:allotRole")
    @PostMapping("/saveUserRoles")
    public ResponseVO saveUserRoles(Long userId, String roleIds) {
        if (StringUtils.isEmpty(userId)) {
            return ResultUtil.error("error");
        }
        userRoleService.addUserRole(userId, roleIds);
        return ResultUtil.success("成功");
    }

    //@RequiresPermissions("user:add")
    @PostMapping(value = "/add")
    public ResponseVO add(UserExtend user) {
        UserExtend u = userService.getByUserName(user.getUsername());
        if (u != null) {
            return ResultUtil.error("该用户名[" + user.getUsername() + "]已存在！请更改用户名");
        }
        try {
            user.setPassword(PasswordUtil.encrypt(user.getPassword(), user.getUsername()));
            userService.insert(user);
            return ResultUtil.success("成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("error");
        }
    }

   // @RequiresPermissions(value = {"user:batchDelete", "user:delete"}, logical = Logical.OR)
    @PostMapping(value = "/remove")
    public ResponseVO remove(Long[] ids) {
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        for (Long id : ids) {
            userRoleService.removeByUserId(id);
        }
        userService.deleteBatchIds(ids);
        return ResultUtil.success("成功删除 [" + ids.length + "] 个用户");
    }

    //@RequiresPermissions("user:edit")
    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.userService.getByPrimaryKey(id));
    }

    //@RequiresPermissions("user:edit")
    @PostMapping("/edit")
    public ResponseVO edit(UserExtend user) {
        try {
            userService.updateById(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("用户修改失败！");
        }
        return ResultUtil.success(ResponseStatusEnum.SUCCESS);
    }
}
