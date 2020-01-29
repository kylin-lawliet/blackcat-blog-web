package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.extend.UserExtend;
import com.blackcat.blog.core.extend.UserRoleExtend;
import com.blackcat.blog.core.mapper.SysUserRoleMapper;
import com.blackcat.blog.core.entity.SysUserRole;
import com.blackcat.blog.core.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p> 用户与角色业务实现
 * @author : blackcat
 * @date : 2020/1/16 20:17
*/
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired(required = false)
    private SysUserRoleMapper resourceMapper;

    @Override
    public void addUserRole(Long userId, String roleIds) {
        //删除
        removeByUserId(userId);
        //添加
        String[] roleIdArr = roleIds.split(",");
        if (roleIdArr.length == 0) {
            return;
        }
        UserRoleExtend u = null;
        List<UserRoleExtend> roles = new ArrayList<>();
        for (String roleId : roleIdArr) {
            if (StringUtils.isEmpty(roleId)) {
                continue;
            }
            u = new UserRoleExtend();
            u.setUserId(userId);
            u.setRoleId(Long.parseLong(roleId));
            roles.add(u);
        }
        insertList(roles);
    }

    public void insertList(List<UserRoleExtend> entities) {
        Assert.notNull(entities, "entities不可为空！");
        if (CollectionUtils.isEmpty(entities)) {
            return;
        }
        List<SysUserRole> sysUserRole = new ArrayList<>();
        for (UserRoleExtend ur : entities) {
            ur.setUpdateTime(new Date());
            ur.setCreateTime(new Date());
            sysUserRole.add(ur.getSysUserRole());
        }
        //resourceMapper.insertList(sysUserRole);
    }

    @Override
    public void removeByUserId(Long userId) {
        resourceMapper.deleteById(userId);
    }

    @Override
    public boolean insert(UserRoleExtend entity) {
        Assert.notNull(entity, "UserRole不可为空！");
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        resourceMapper.insert(entity.getSysUserRole());
        return false;
    }

    @Override
    public boolean updateById(UserRoleExtend entity) {
        Assert.notNull(entity, "UserRole不可为空！");
        entity.setUpdateTime(new Date());
        return resourceMapper.updateById(entity.getSysUserRole()) > 0;
    }

    @Override
    public void deleteBatchIds(Long[] ids) {
        resourceMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public UserRoleExtend getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        SysUserRole sysUserRole = resourceMapper.selectById(primaryKey);
        return null == sysUserRole ? null : new UserRoleExtend(sysUserRole);
    }
}