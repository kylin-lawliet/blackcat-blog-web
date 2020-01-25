package com.blackcat.blog.core.extend;

import com.blackcat.blog.core.entity.SysRoleMenu;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * <p> 描述 ：
 * @author : blackcat
 * @date : 2020/1/25 18:00
 */
public class RoleMenuExtend {

    private SysRoleMenu sysRoleMenu;

    public RoleMenuExtend() {
        this.sysRoleMenu = new SysRoleMenu();
    }

    public RoleMenuExtend(SysRoleMenu sysRoleMenu) {
        this.sysRoleMenu = sysRoleMenu;
    }

    @JsonIgnore
    public SysRoleMenu getSysRoleMenu() {
        return this.sysRoleMenu;
    }

    public Long getRoleId() {
        return this.sysRoleMenu.getRoleId();
    }

    public void setRoleId(Long roleId) {
        this.sysRoleMenu.setRoleId(roleId);
    }

    public Long getId() {
        return this.sysRoleMenu.getId();
    }

    public void setId(Long id) {
        this.sysRoleMenu.setId(id);
    }

    public Date getCreateTime() {
        return this.sysRoleMenu.getCreateTime();
    }

    public void setCreateTime(Date regTime) {
        this.sysRoleMenu.setCreateTime(regTime);
    }

    public Date getUpdateTime() {
        return this.sysRoleMenu.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.sysRoleMenu.setUpdateTime(updateTime);
    }

}
