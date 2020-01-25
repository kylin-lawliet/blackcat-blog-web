package com.blackcat.blog.core.extend;

import com.blackcat.blog.core.entity.SysUserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @author zjjlive)
 * @version 1.0
 * @website https://www.foreknow.me
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public class UserRoleExtend {

    private SysUserRole sysUserRole;

    public UserRoleExtend() {
        this.sysUserRole = new SysUserRole();
    }

    public UserRoleExtend(SysUserRole sysUserRole) {
        this.sysUserRole = sysUserRole;
    }

    @JsonIgnore
    public SysUserRole getSysUserRole() {
        return this.sysUserRole;
    }

    public Long getUserId() {
        return this.sysUserRole.getUserId();
    }

    public void setUserId(Long userId) {
        this.sysUserRole.setUserId(userId);
    }

    public Long getRoleId() {
        return this.sysUserRole.getRoleId();
    }

    public void setRoleId(Long roleId) {
        this.sysUserRole.setRoleId(roleId);
    }

    public Date getCreateTime() {
        return this.sysUserRole.getCreateTime();
    }

    public void setCreateTime(Date regTime) {
        this.sysUserRole.setCreateTime(regTime);
    }

    public Date getUpdateTime() {
        return this.sysUserRole.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.sysUserRole.setUpdateTime(updateTime);
    }
}
