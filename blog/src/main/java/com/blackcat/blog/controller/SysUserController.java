package com.blackcat.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackcat.blog.common.constant.RedisKey;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.enums.UserTypeEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.SysUserService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.util.PasswordUtil;
import com.blackcat.blog.util.RedisUtil;
import com.blackcat.blog.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

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
    @Resource
    private RedisUtil redisUtil;

    /**
     * <p> 描述 : 查询列表数据
     * @author : blackcat
     * @date  : 2020/2/6 16:27
     */
    @RequiresPermissions("users")
    @RequestMapping("/list")
    public PageResult list(BaseConditionVO vo){
        Page<SysUser> page = new Page<>(vo.getPageNumber(), vo.getPageSize());
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(vo.getKeywords())){
            queryWrapper.lambda().like(SysUser::getNickname,vo.getKeywords())
                    .or().like(SysUser::getMobile,vo.getKeywords())
                    .or().like(SysUser::getUsername,vo.getKeywords())
                    .or().like(SysUser::getPassword,vo.getKeywords())
                    .or().like(SysUser::getEmail,vo.getKeywords())
                    .or().like(SysUser::getRemark,vo.getKeywords());
        }
        queryWrapper.lambda().orderByDesc(SysUser::getCreateTime);
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
        entity.setUserType(UserTypeEnum.USER);
        iSysUserService.save(entity);
        redisUtil.set(RedisKey.SYS_USER+entity.getId(),entity);
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
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
        redisUtil.deleteSub(RedisKey.SYS_USER,ids);
        return ResultUtil.ok("成功删除 [" + ids.length + "] 个数据");
    }

    /**
     * <p> 描述 : 查询详情
     * @author : blackcat
     * @date  : 2020/2/6 16:27
     */
    @PostMapping("/get/{id}")
    public ResultUtil get(@PathVariable Long id) {
        SysUser sysUser;
        if(redisUtil.hasKey(RedisKey.SYS_USER+id)){
            sysUser = redisUtil.get(RedisKey.SYS_USER + id, SysUser.class);
        }else{
            sysUser = iSysUserService.getById(id);
        }
        return ResultUtil.ok().put("data",sysUser);
    }

    /**
     * <p> 描述 : 编辑
     * @author : blackcat
     * @date  : 2020/2/6 16:27
     */
    @PostMapping("/edit")
    public ResultUtil edit(SysUser entity) {
        try {
         entity.setUpdateTime(LocalDateTime.now());
         iSysUserService.updateById(entity);
         redisUtil.set(RedisKey.SYS_USER+entity.getId(),entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
        }
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }
}
