package com.blackcat.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.SysUserService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.util.PasswordUtil;
import com.blackcat.blog.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p> 系统用户表 前端控制器
 * @author blackcat
 * @date 2020-01-29
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private SysUserService iSysUserService;

    /**
     * <p> 描述 : 查询列表数据
     * @author : blackcat
     * @date  : 2020/2/6 16:27
     */
    @RequiresPermissions("users")
    @RequestMapping("/list")
    public PageResult list(BaseConditionVO vo){
        System.out.println("****");
        Page<SysUser> page = new Page<>(vo.getPageNumber(), vo.getPageSize());
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(vo.getKeywords())){
            queryWrapper.lambda()
                    .like(SysUser::getNickname,vo.getKeywords())
                    .like(SysUser::getMobile,vo.getKeywords())
                    .like(SysUser::getUsername,vo.getKeywords())
                    .like(SysUser::getPassword,vo.getKeywords())
                    .like(SysUser::getEmail,vo.getKeywords())
                    .like(SysUser::getRemark,vo.getKeywords())
                    .orderByDesc(SysUser::getCreateTime);
        }
        iSysUserService.page(page, queryWrapper);
        return ResultUtil.tablePage(page);
    }

    /**
     * <p> 描述 : 添加
     * @author : blackcat
     * @date  : 2020/2/6 16:27
     */
    @RequiresPermissions("user:add")
    @PostMapping(value = "/add")
    public ResultUtil add(SysUser entity) throws Exception {
        SysUser user = iSysUserService.getOne(new QueryWrapper<SysUser>().eq("username",  entity.getUsername()));
        if (user != null) {
             return ResultUtil.error("该用户名[" + user.getUsername() + "]已存在！请更改用户名");
        }
        entity.setPassword(PasswordUtil.encrypt(entity.getPassword(), entity.getUsername()));
        entity.setUserType("USER");
        iSysUserService.save(entity);
        return ResultUtil.ok(String.valueOf(ResponseStatusEnum.SUCCESS));
    }

    /**
     * <p> 描述 : 删除
     * @author : blackcat
     * @date  : 2020/2/6 16:27
     */
    @RequiresPermissions(value = {"user:batchDelete", "user:delete"}, logical = Logical.OR)
    @PostMapping(value = "/remove")
    public ResultUtil remove(Long[] ids) {
        if (null == ids) {
         return ResultUtil.error(String.valueOf(ResponseStatusEnum.REMOVE_ERROR));
        }
        iSysUserService.deleteBatchIds(ids);
        return ResultUtil.ok("成功删除 [" + ids.length + "] 个数据");
    }

    /**
     * <p> 描述 : 查询详情
     * @author : blackcat
     * @date  : 2020/2/6 16:27
     */
    @PostMapping("/get/{id}")
    public ResultUtil get(@PathVariable Long id) {
     return ResultUtil.ok().put("data",iSysUserService.getById(id));
    }

    /**
     * <p> 描述 : 编辑
     * @author : blackcat
     * @date  : 2020/2/6 16:27
     */
    @PostMapping("/edit")
    public ResultUtil edit(SysUser entity) {
        try {
         iSysUserService.updateById(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
        }
        return ResultUtil.ok(String.valueOf(ResponseStatusEnum.SUCCESS));
    }
}
