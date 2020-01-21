package com.blackcat.blog.core.extend;

import com.blackcat.blog.core.enums.MenuTypeEnum;
import com.blackcat.blog.core.entity.SysMenu;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

/**
 * <p> ：权限扩展类
 * @author : blackcat
 * @date : 2020/1/17 14:20
 */
public class MenuExtend extends BaseExtend<SysMenu>{
    private SysMenu SysMenu;

    public MenuExtend() {
        this.SysMenu = new SysMenu();
    }

    public MenuExtend(SysMenu SysMenu) {
        this.SysMenu = SysMenu;
    }

    @JsonIgnore
    public SysMenu getSysMenu() {
        return this.SysMenu;
    }

    public Long getId() {
        return this.SysMenu.getId();
    }

    public void setId(Long id) {
        this.SysMenu.setId(id);
    }

    public String getName() {
        return this.SysMenu.getName();
    }

    public void setName(String name) {
        this.SysMenu.setName(name);
    }

    public MenuTypeEnum getType() {
        return this.SysMenu.getType() != null ? MenuTypeEnum.valueOf(this.SysMenu.getType()) : null;
    }

    public void setType(MenuTypeEnum type) {
        this.SysMenu.setType(type.toString());
    }

    public String getUrl() {
        return this.SysMenu.getUrl();
    }

    public void setUrl(String url) {
        this.SysMenu.setUrl(url);
    }

    public String getPermission() {
        return this.SysMenu.getPermission();
    }

    public void setPermission(String permission) {
        this.SysMenu.setPermission(permission);
    }

    public Long getParentId() {
        return this.SysMenu.getParentId();
    }

    public void setParentId(Long parentId) {
        this.SysMenu.setParentId(parentId);
    }

    public Integer getSort() {
        return this.SysMenu.getSort();
    }

    public void setSort(Integer sort) {
        this.SysMenu.setSort(sort);
    }

    public boolean isAvailable() {
        Boolean value = this.SysMenu.getAvailable();
        return value != null ? value : false;
    }

    public void setAvailable(boolean available) {
        this.SysMenu.setAvailable(available);
    }

    public Boolean getExternal() {
        Boolean value = this.SysMenu.getExternal();
        return null == value ? false : value;
    }

    public void setExternal(Boolean external) {
        this.SysMenu.setExternal(external);
    }

    public String getIcon() {
        return this.SysMenu.getIcon();
    }

    public void setIcon(String icon) {
        this.SysMenu.setIcon(icon);
    }

    public Date getCreateTime() {
        return this.SysMenu.getCreateTime();
    }

    public void setCreateTime(Date regTime) {
        this.SysMenu.setCreateTime(regTime);
    }

    public Date getUpdateTime() {
        return this.SysMenu.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.SysMenu.setUpdateTime(updateTime);
    }

    public SysMenu getParent() {
        return this.SysMenu.getParent();
    }

    public void setParent(SysMenu parent) {
        this.SysMenu.setParent(parent);
    }

    public List<SysMenu> getNodes() {
        return this.SysMenu.getNodes();
    }

    public void setNodes(List<SysMenu> nodes) {
        this.SysMenu.setNodes(nodes);
    }
}
