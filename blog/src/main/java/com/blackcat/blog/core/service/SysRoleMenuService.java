package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.SysRoleMenu;
import com.blackcat.blog.core.extend.RoleMenuExtend;
import com.blackcat.blog.core.object.AbstractIService;

/**
 * <p> 角色与权限业务接口
 * @author : blackcat
 * @date : 2020/1/16 20:13
*/
public interface SysRoleMenuService extends AbstractIService<RoleMenuExtend, Long> {
    /**
     * 添加角色资源
     *
     * @param roleId
     * @param resourcesIds
     */
    void addRoleMenu(Long roleId, String resourcesIds);

    /**
     * 通过角色id批量删除
     *
     * @param roleId
     */
    void removeByRoleId(Long roleId);
}

